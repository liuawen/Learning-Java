/**
 * @author Liu Awen
 * @create 2018-05-10 17:01
 */
/*
2、数组的练习
用一个数组存储26个英文字母的小写形式，
并遍历显示
'a'->'A’
*/
class Test09_Exer5{
    public static void main(String[] args){
        //用一个数组存储26个英文字母的小写形式
        //(1)声明并创建数组
        char[] letters = new char[26];

        //(2)为元素赋值，即把'a','b'等存储到letters数组中
        //因为有规律，所以用循环赋值
        for(int i=0; i<letters.length; i++){
            letters[i] = (char)('a' + i);
        }

        //(3)显示结果
        //'a'->'A’
        //->左边就是元素的值，右边是根据元素的值，算出来的
        //'a'的编码值是97，'A'编码值为65，差32
        //'b'的编码值是98，'B'编码值为66，差32
        for(int i=0; i<letters.length; i++){
            System.out.println(letters[i] +"->" + (char)(letters[i]-32));
        }
        //Result
        //a->A
        //b->B
        //c->C
        //d->D
        //e->E
        //f->F
        //g->G
        //h->H
        //i->I
        //j->J
        //k->K
        //l->L
        //m->M
        //n->N
        //o->O
        //p->P
        //q->Q
        //r->R
        //s->S
        //t->T
        //u->U
        //v->V
        //w->W
        //x->X
        //y->Y
        //z->Z
        //
        //Process finished with exit code 0
    }
}