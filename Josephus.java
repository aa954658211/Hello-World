public class Josephus{
        private Josephus next;
        private int value;

        public Josephus() {
        }

        public Josephus(int value) {
            this.value = value;
        }

        public Josephus add(int value){
            if (this.next == null){
                this.next = new Josephus(value);
            } else{
                Josephus node = new Josephus(value);
                node.next = this.next;
                this.next = node;
            }
            return this.next;
        }
        public Josephus add(Josephus node){
            this.next = node;
            return this.next;
        }

        /**
         * 摘链，从第一个开始循环，每次都循环step次，记录循环的起点
         * @param step
         */
        public void eliminate(int step){
            Josephus start = this;
            while (start != null){
                Josephus pre = null;
                for (int i = 0; i < step-1; i++) {//每次都循环step次
                    if (i == step-2){
                        pre = start;
                    }
                    start = start.next;
                }
                System.out.print(start.value+" ");
                //摘链
                pre.next = start.next;
                start.next = null;
                start = pre.next;

            }
        }


public static void josephus(int[] n,int m){
        int kill = 0 ;//记录出列的人数
        int flag = 1 ;//记录即将出列的序号，第m个出列
        while (kill < n.length){
            for (int i = 0; i < n.length; i++) {//内循环查找出列的序号，出列的人赋值为-1
                if (flag < m && n[i] != -1){
                    flag++;
                }else if (flag == m && n[i] != -1){
                    System.out.print(n[i]+" ");
                    n[i] = -1;
                    flag = 1;
                    kill++;
                }
            }

        }
    }

    public static void josephus2(int[] n,int m){
        int kill = 0 ;//记录出列的人数
        int flag = 0 ;//记录迭代数组的序号
        int procedure = 0;//即将被出列的第m人
        while (kill < n.length){
            while (procedure < m){
                if (n[flag] != -1 ){
                    procedure++;
                    if (procedure == m){
                        System.out.print(n[flag]+" ");
                        n[flag] = -1;
                    }
                }
                flag = (flag + 1)%n.length;
            }
            procedure = 0;
            kill++;
        }
    }

 
    }
