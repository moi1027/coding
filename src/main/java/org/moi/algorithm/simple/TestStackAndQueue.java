package org.moi.algorithm.simple;

/**
 * @program:
 * @description: 栈和队列的那些事
 * @author: moi
 * @create: 2020/11/15 21:28
 **/
public class TestStackAndQueue {

    /**
     * 默认用链表实现，这里展示用数组实现的方式
     */
    public static class TestQueue{
        private int[] arr;
        //进入队列元素的下标
        private int pushi;
        //出队列元素的下标
        private int polli;
        //队列的大小
        private int size;
        private int limit;

        public TestQueue(int limit){
            arr = new int[limit];
            polli = 0;
            pushi = 0;
            size = 0; //需要固定一个数组的大小
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit){
                throw new RuntimeException("队列满了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("队列空了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }
        public  int nextIndex(int index){
            index = (index+1)%limit;
            return index;
        }
    }

    /**
     * 这里实现的是栈
     */
    public static class TestStack{
        private int[] arr;
        private int pushi;
        private int size;
        private int limit;

        public TestStack(int limit){
            arr = new int[limit];
            pushi = 0;
            size = 0; //需要固定一个数组的大小
            this.limit = limit;
        }

        public void push(int value){
            if(size == limit){
                throw new RuntimeException("栈满了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if(size == 0){
                throw new RuntimeException("栈空了");
            }
            size--;
            int ans = arr[pushi];
            pushi = nextIndex1(pushi);
            return ans;
        }
        public  int nextIndex(int index){
            index = (index+1)%limit;
            return index;
        }

        public  int nextIndex1(int index){
            if(index == 0){
                if(size == 0){
                    return 0;
                }else{
                    return limit-1;
                }
            }
            index--;
            return index;
        }
    }


    public static void QueueAction(){
        TestQueue t = new TestQueue(7);
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);
        t.push(5);
        t.push(6);
        t.push(7);
        int a =  t.pop();
        t.push(8);
        System.out.println(a);
        t.push(9);


    }

    public static void StackAction(){
        TestStack t = new TestStack(7);
        t.push(1);
//        t.push(2);
//        t.push(3);
//        t.push(4);
//        t.push(5);
//        t.push(6);
//        t.push(7);
        int a =  t.pop();
        t.push(8);
        System.out.println(a);



    }
    public static void main(String[] args) {
      //  QueueAction();
        StackAction();
    }

}
