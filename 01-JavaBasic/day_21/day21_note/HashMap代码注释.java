    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
	//目的：干扰hashCode值
    static final int hash(Object key) {
        int h;
		//如果key是null，hash是0
		//如果key非null，用key的hashCode值 与 key的hashCode值高16进行异或
		//		即就是用key的hashCode值高16位与低16位进行了异或的干扰运算
		
		/*
		index = hash & table.length-1
		如果用key的原始的hashCode值  与 table.length-1 进行按位与，那么基本上高16没机会用上。
		这样就会增加冲突的概率，为了降低冲突的概率，把高16位加入到hash信息中。
		*/
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; //数组
		Node<K,V> p; //一个结点
		int n, i;//n是数组的长度   i是下标
		
		//tab和table等价
		//如果table是空的
        if ((tab = table) == null || (n = tab.length) == 0){
            //n = (tab = resize()).length;
			tab = resize();
			n = tab.length;
			/*
			如果table是空的，resize()完成了
			①创建了一个长度为16的数组
			②threshold = 12
			
			n= 16
			*/
        }
		//i = (n - 1) & hash ，下标 = 数组长度-1 & hash
		//p = tab[i] 
		//if(p==null) 条件满足的话说明 table[i]还没有元素
		if ((p = tab[i = (n - 1) & hash]) == null){
			//把新的映射关系直接放入table[i]
            tab[i] = newNode(hash, key, value, null);
			//newNode（）方法就创建了一个Node类型的新结点，新结点的next是null
        }else {
            Node<K,V> e; 
			K k;
			//p是table[i]中第一个结点
			//if(table[i]的第一个结点与新的映射关系的key重复)
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;//用e记录这个table[i]的第一个结点
			}else if (p instanceof TreeNode){//如果table[i]第一个结点是一个树结点
                //单独处理树结点
				e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }else {
				//table[i]的第一个结点不是树结点，也与新的映射关系的key不重复
				//binCount记录了table[i]下面的结点的个数
                for (int binCount = 0; ; ++binCount) {
					//如果p的下一个结点是空的，说明当前的p是最后一个结点
                    if ((e = p.next) == null) {
						//把新的结点连接到table[i]的最后
                        p.next = newNode(hash, key, value, null);
						
						//如果binCount>=8-1，达到7个时
                        if (binCount >= TREEIFY_THRESHOLD - 1){ // -1 for 1st
                            //要么扩容，要么树化
							treeifyBin(tab, hash);
						}
                        break;
                    }
					//如果key重复了，就跳出for循环
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
					}
                    p = e;
                }
            }
			//如果这个e不是null，说明有key重复，就考虑替换原来的value
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null){
                    e.value = value;
				}
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
		
		//元素个数增加
		//size达到阈值
        if (++size > threshold){
            resize();//一旦扩容，重新调整所有映射关系的位置
		}
        afterNodeInsertion(evict);//什么也没干
        return null;
    }	
	
   final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;//oldTab原来的table
		//oldCap：原来数组的长度
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
		
		//oldThr：原来的阈值
        int oldThr = threshold;//最开始threshold是0
		
		//newCap，新容量
		//newThr：新阈值
        int newCap, newThr = 0;
        if (oldCap > 0) {//说明原来不是空数组
            if (oldCap >= MAXIMUM_CAPACITY) {//是否达到数组最大限制
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY){
				//newCap = 旧的容量*2 ，新容量<最大数组容量限制
				//新容量：32,64，...
				//oldCap >= 初始容量16
				//新阈值重新算 = 24，48 ....
                newThr = oldThr << 1; // double threshold
			}
        }else if (oldThr > 0){ // initial capacity was placed in threshold
            newCap = oldThr;
        }else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;//新容量是默认初始化容量16
			//新阈值= 默认的加载因子 * 默认的初始化容量 = 0.75*16 = 12
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;//阈值赋值为新阈值12，24.。。。
		
		//创建了一个新数组，长度为newCap，16，32,64.。。
        @SuppressWarnings({"rawtypes","unchecked"})
            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
		
		
        if (oldTab != null) {//原来不是空数组
			//把原来的table中映射关系，倒腾到新的table中
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {//e是table下面的结点
                    oldTab[j] = null;//把旧的table[j]位置清空
                    if (e.next == null)//如果是最后一个结点
                        newTab[e.hash & (newCap - 1)] = e;//重新计算e的在新table中的存储位置，然后放入
                    else if (e instanceof TreeNode)//如果e是树结点
						//把原来的树拆解，放到新的table
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
						/*
						把原来table[i]下面的整个链表，重新挪到了新的table中
						*/
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }	
	
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
		//创建一个新结点
	   return new Node<>(hash, key, value, next);
    }

    final void treeifyBin(Node<K,V>[] tab, int hash) {
        int n, index; 
		Node<K,V> e;
		//MIN_TREEIFY_CAPACITY：最小树化容量64
		//如果table是空的，或者  table的长度没有达到64
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            resize();//先扩容
        else if ((e = tab[index = (n - 1) & hash]) != null) {
			//用e记录table[index]的结点的地址
            TreeNode<K,V> hd = null, tl = null;
			/*
			do...while，把table[index]链表变为红黑树
			*/
            do {
                TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
			
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }
    }	