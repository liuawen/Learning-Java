package codingInterviewGuide.part1.catdogQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *猫狗对列
 */
public class DogCatQueue {
    public Queue<PetEnterQueue> dogQueue;
    public Queue<PetEnterQueue> catQueue;
    private long count;

    public DogCatQueue() {
        this.dogQueue =new ArrayDeque<PetEnterQueue>();
        this.catQueue =new ArrayDeque<PetEnterQueue>();
        this.count = 0;
    }
    public void add(Pet pet){
        if("cat".equals(pet.getType())){
            catQueue.add(new PetEnterQueue(pet,count++));
        }else{
            if("dog".equals(pet.getType())){
                dogQueue.add(new PetEnterQueue(pet,count++));
            }else{
                throw new RuntimeException("err, not cat or dog");
            }
        }
    }
    //利用时间戳,注意只用弹出一个，注意读题
    public Pet pollAll(){
        if(!catQueue.isEmpty()&&!dogQueue.isEmpty()){
            if(catQueue.peek().getCount()>dogQueue.peek().getCount()){
                return catQueue.poll().getPet();
            }else{
                return dogQueue.poll().getPet();
            }
        }else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        }else{
            throw new RuntimeException("err, not cat or dog");
        }
    }
    public Pet pollCat(){
        return catQueue.poll().getPet();
    }
    public Pet pollDog(){
        return dogQueue.poll().getPet();
    }
    public boolean isEmpty(){
        return count==0?true:false;
    }
    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }
    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }
}
