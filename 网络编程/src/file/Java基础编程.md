【程序1】

题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子对数为多少？

程序分析：

兔子的规律为数列1,1,2,3,5,8,13,21....

做这种题目，最好的做法就是找出规律，跟高中的数列一样

本题有：a[n]=a[n-1]+a[n-1]，而第一第二项都知道了，后面的值也可以求得

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:13
     */
    public class Interview01 {
     
        public static void main(String[] args) {
            System.out.print("请输入你想知道的兔子数量的月份：");
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();//获取输入的整数
            System.out.println("第" + n + "个月兔子总数为" + fun(n));
            scanner.close();
        }
     
        //求得所需月份的兔子的数量，返回值为兔子的数量
        private static int fun(int n) {
            if (n == 1 || n == 2){
                return 1;
            } else {
                return fun(n - 1) + fun(n - 2);
            }
        }
    }

 

【程序2】

题目：判断101-200之间有多少个素数，并输出所有素数。

程序分析：

素数是：只能被1或本身整除的数，如：3,5,7,11,131... 

判断素数的方法：用一个数分别去除2到sqrt(这个数)，

其实用这个数分别去除2到他本身少1的数也可以，但是运算时间增加了

如果能被整除，则表明此数不是素数，反之是素数。

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview02 {
     
        public static void main(String[] args) {
            int sum = 0;
            for (int i = 100; i < 200; i++) {
                if (isRightNum(i)) { //判断这个数是不是素数
                    System.out.print(i + "   ");
                    sum++;
                    if (sum % 5 == 0) { //五个一行
                        System.out.println();
                    }
                }
            }
            System.out.println();
            System.out.println("素数的整数：" + sum);
        }
     
        //判断这个数是不是素数的具体代码
        private static boolean isRightNum(int i) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) { //如果能整除，就说明不是素数，可以马上中断，继续对下一个数判断
                    return false;
                }
            }
            return true;
        }
    }



【程序3】

题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。

例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。

程序分析：利用for循环控制100-999个数，每个数分解出个位，十位，百位。

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview03 {
     
        public static void main(String[] args) {
            int sum = 0;//水仙花的总数
            for (int i = 100; i < 1000; i++) {
                int bite = i % 10;          //求得个位
                int ten = i / 10 % 10;    //求得十位
                int hundred = i / 100;//求得百位
                //如果符合水仙花条件的数打印出来
                if (i == (bite * bite * bite) +
                        (ten * ten * ten) + (hundred * hundred * hundred)) {
                    System.out.print(i + "   ");
                    sum++;
                }
            }
            System.out.println("总共有水仙花个数：" + sum);
        }
    }



【程序4】

题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。

程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成：

1、如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。

2、如果n<>k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步。

3、如果n不能被k整除，则用k+1作为k的值,重复执行第一步。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview04 {
     
        public static void main(String[] args) {
     
            System.out.print("请输入一个你要分解的正整数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();//获取输入的数字
            System.out.println();
            System.out.print(input + "=");
            for (int i = 2; i < input + 1; i++) {
                while (input % i == 0 && input != i) {
                    input = input / i;
                    System.out.print(i + "*");
                }
     
                if (input == i) {//上面的都不能整除，说明这是一个质数
                    System.out.print(i);
                    break;
                }
            }
            scanner.close();
        }
    }



【程序5】

题目：利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。

程序分析：(a>b)?a:b这是条件运算符的基本例子。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview05 {
        public static void main(String[] args) {
     
            System.out.println("请输入你的分数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();//获取输入
     
            //等级判断
            String belong = input >= 90 ? "A" : (input >= 60 ? "B" : "c");
            System.out.println(input + "分属于：" + belong);
            scanner.close();
        }
    }



【程序6】

题目：输入两个正整数m和n，求其最大公约数和最小公倍数。

程序分析：利用辗除法。 

这里有一个知识点要记住的，最大公约数和最小公倍数的求法  

1、先求最大公约数bigDivisor

2、就可以很方便获得最小公倍数multiple=input1*input2/bigDIvisor

 

这里最重要的就是求最大公约数：求法如下 

1、用大的数对小的数求余

2、把小的数赋值给大的数，把求余获得的结果赋值给小的数，

3、循环上一步的操作，直到求余的结果为零

4、上一步被求余的数就是我们要的最大公约数，不信的话，你可以动手试试

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview06 {
        public static void main(String[] args) {
            int bigDivisor = 0;//定义最大公约数
            int multiple = 0;//定义最小公倍数
            System.out.println("请输入两个整数：");
            Scanner scanner = new Scanner(System.in);
            int input1 = scanner.nextInt();//获取第一个数
            int input2 = scanner.nextInt();//获取第二个数
            multiple = input1 * input2;//这个值保存，求公约数后，方便求得最小公倍数
            int temp = 1;// 交换用的中间数
            if (input2 > input1) {//确保第一个数不小于第二个数
                temp = input1;
                input1 = input2;
                input2 = temp;
            }
            while (temp != 0) { //求余结果不等于零，就一直循环
                temp = input1 % input2;//求余结果
                input1 = input2;//大的数已经没用了，用小的数替代
                input2 = temp;//把求余的结果赋值给小的数
            }
            bigDivisor = input1;//最后一次求余结果为零时，被求余的数
            multiple = multiple / bigDivisor;
            System.out.println("最大公约数是：" + bigDivisor);
            System.out.println("最小公倍数是：" + multiple);
            scanner.close();
        }
    }


【程序7】

题目：输入一行字符，分别统计出其英文字母、空格、数字和其它字符的个数。

程序分析：

这里的需要的知识点:

1、获取一行字符串，nextLine（）

2、把字符串的每一个字符赋值到一个数值中

3、对比每一个数值在ASK码的范围，就可以确定它符号的类别

4、char字符ASK码的范围

         （1）数字0到9： 48~57
    
         （2）字母A到Z：65到90 a到z：97到122
    
         （3）空格是32 
    
    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview07 {
        public static void main(String[] args) {
            int num = 0;//数字的个数
            int letter = 0;//字母的个数
            int space = 0;//空格的个数
            int others = 0;//其他的个数
            System.out.println("请输入一串字符：");
            Scanner scanner = new Scanner(System.in);
            String string = scanner.nextLine();//获取一行字符串
            //把字符串里面的值赋值给一个字符型数组
            char[] arr = string.toCharArray();
            //遍历字符串里面的所有值
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 48 && arr[i] <= 57) {//字符是数字
                    num++;
                } else if ((arr[i] >= 65 && arr[i] <= 90) || (arr[i] >= 97 && arr[i] <= 122)) {
                    letter++;
                } else if (arr[i] == 32) {
                    space++;
                } else {
                    others++;
                }
            }
            System.out.println("数字：" + num + "个，字母：" + letter + "个，空格：" + space + "个，其他：" + others + "个");
            scanner.close();
        }
    }

 

【程序8】

题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。输出结果的形式如：2+22+222=246；

程序分析：关键是计算出每一项的值。

比如获取的数字为：a，出现的项数为：n

总结一下，可以得到一下规律：

1、第一项有一个a,最后一项有n个a

2、 第1和第2项相差2*10，第2和第三项相差2*100，第k和第k+1项相差2*（10的k次方）

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview08 {
        public static void main(String[] args) {
            int n = 0, a = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入a的值:");
            a = scanner.nextInt();
            System.out.println("请输入n的值：");
            n = scanner.nextInt();
            int[] arr = new int[n];//创建数组长度为输入的项数
            int i = 1;//while循环初始化的值
            arr[0] = a;//数组的第一个值为3
            //把每一项的值赋值给数组里面的数
            while (i < n) {
                a *= 10;
                arr[i] = a + arr[i - 1];
                i++;
            }
            //求和
            int sum = 0;
            for (int s : arr) {
                sum += s;//累加求和
                if (s == arr[n - 1]) {
                    System.out.print(s);
                    break;//最后一次只输出结果
                }
                System.out.print(s + "+");//前面的值输出结果，后面还要加一个加号
            }
            System.out.println("=" + sum);//完美结束
        }
    }



【程序9】

题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。

判断完数的方法：

利用for循环判断所有因数的和是否和输入的值是否相等，相等的话输出

求因数的方法：

1、两个嵌套循环，并用i%j==0,关于i和j的值范围：i从1到1000逐个遍历，j只需不大于i/2+1即可

比如：48，最大的因数才24,99最大的因数是33，因数不会大于本身数的一半

2、j就是我们所求的因数，把所有的j相加，就可以得到因数总和

3、因数总和已经包含1了，因为第一次就保存1了

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview09 {
        public static void main(String[] args) {
            System.out.println("1000以内的因数有：");
            for (int i = 1; i <= 1000; i++) {
                int sum = 0;//所有因数的总和
                for (int j = 1; j < i / 2 + 1; j++) {
                    if (i % j == 0) {//判断范围内的所有j相加，就是因数总和
                        sum = sum + j;
                        if (i == sum) {
                            System.out.print(i + "  ");
                        }
                    }
                }
            }
        }
    }



【程序10】

题目：一球从h米高度自由落下，每次落地后反跳回原高度的一半；

再落下，求它在 第n次落地时，共经过多少米？第n次反弹多高？

程序分析：反弹的高度:(1/2)的n次方*h

1、经过的距离：这个可以总结得到：第一次落地经过：h,第二次落地经过：h+(h/2)*2,

2、第三次落地经过：h+(h/2)*2+(h/2/2)*2 

3、那么第n次落地经过：  h+(h/2)*2+(h/2/2)*2 +...+h/(2的n-1次方)*2

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview10 {
        public static void main(String[] args) {
            System.out.println("请输入小球下落的高度和落地的次数：");
            Scanner scanner = new Scanner(System.in);
            float h = scanner.nextFloat();
            float n = scanner.nextFloat();
            //float h=100,n=3;
            float sum = h;//经过的路径总和
            h /= 2;//第一次下落是在最高点，sum中不会有两倍的h，所以写在外面，循环从第二次开始
            for (int i = 2; i <= n; i++) {
                //经过的距离的总和
                sum += h * 2;
                //第N次反弹的高度为
                h /= 2;
            }
            System.out.println("在" + 100 + "米，经过" + n + "次后，能反弹：" + h + "米，经过的距离：" + sum);
            scanner.close();
        }
    }



【程序11】

题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？

程序分析：可填在百位、十位、个位的数字都是1、2、3、4。这里要用3个for循环

用if判断条件是否符合，符合条件的数字打印出来,并计算个数总和

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview11 {
        public static void main(String[] args) {
            int sum = 0;
            for (int bite = 1; bite < 5; bite++) {
                for (int ten = 1; ten < 5; ten++) {
                    for (int hundred = 1; hundred < 5; hundred++) {
                        if (bite != ten && bite != hundred && ten != hundred) {//符合条件的数字
                            System.out.print((hundred * 100 + ten * 10 + bite) + "  ");
                            sum++;//计算个数
                            if (sum % 10 == 0) {//十个一行
                                System.out.println();
                            }
                        }
                    }
                }
            }
            System.out.println("\n总共有：" + sum + "个这样的数");
        }
    }



【程序12】

题目：企业发放的奖金根据利润提成。利润(I)低于或等于10万元时，奖金可提10%；利润高于10万元，低于20万元时，低于10万元的部分按10%提成，高于10万元的部分，可可提成7.5%；20万到40万之间时，高于20万元的部分，可提成5%；40万到60万之间时高于40万元的部分，可提成3%；60万到100万之间时，高于60万元的部分，可提成1.5%，高于100万元时，超过100万元的部分按1%提成，从键盘输入当月利润I，求应发放奖金总数？

程序分析：请利用数轴来分界，定位。注意定义时需把奖金定义成长整型。

超过      10万          20万         40万          60万          100万          

10*0.1   10*0.075   20*0.05    20*0.03     40*0.015      0.01

1            1.75          2.75         3.35           3.95    

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview12 {
        public static void main(String[] args) {
            System.out.println("请输入你创造的利润(单位：万元):");
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextDouble()) {
                System.out.println("请输入金额数字：");
                scanner.next();
            }
            double profit = scanner.nextDouble();
            double bonus = 0;
            if (profit <= 10) {
                bonus = profit * 0.1;
            } else if (profit <= 20) {
                bonus = (profit - 10) * 0.075 + 1;
            } else if (profit <= 40) {
                bonus = (profit - 10) * 0.05 + 1.75;
            } else if (profit <= 60) {
                bonus = (profit - 10) * 0.03 + 2.75;
            } else if (profit <= 100) {
                bonus = (profit - 10) * 0.015 + 3.35;
            } else {
                bonus = (profit - 100) * 0.01 + 3.95;
            }
            System.out.println(profit + "万元利润，可以获得：" + bonus + "万元");
            scanner.close();
        }
    }



【程序13】

题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？

程序分析：在10万以内判断，

用for循环判断：先将该数加上100后再开方，再将该数加上268后再开方，

如果开方后的结果再平方后分别和i+100,i+268相等，即是结果。 

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview13 {
        public static void main(String[] args) {
            for (int i = 0; i < 10000; i++) {
                int num1 = (int) Math.sqrt(i + 100);//开方，值已固定了
                int num2 = (int) Math.sqrt(i + 268);
                if ((num1 * num1 == (i + 100)) && (num2 * num2 == (i + 268))) {//符合条件的打印出来
                    System.out.println(i + "  ");
                }
            }
        }
    }



【程序14】

题目：输入某年某月某日，判断这一天是这一年的第几天？

程序分析：以3月5日为例，应该先把前两个月的加起来，然后再加上5天即本年的第几天，特殊情况，闰年且输入月份大于3时需考虑多加一天。

闰年的条件：year除以400能整除，或者year除以4能整除，但是不能是100的倍数

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview14 {
        public static void main(String[] args) {
            System.out.println("请输入年月日（用空格隔开）：");
            Scanner scanner = new Scanner(System.in);
            int year = scanner.nextInt();//获取年份
            int month = scanner.nextInt();//获取月份
            int day = scanner.nextInt();//获取天数
            int sum = 0;//天数总和
            //创建一个包含月份天数的数组，先按小年计算，如果是闰年，并且在三月以后再加1
            int[] arr = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            sum = day;//输入的天数肯定是要加的
            for (int i = 1; i < month; i++) {  //加上包含的月份天数
                sum += arr[i];
            }
            //最后判断是否是闰年，如果是的话再加1，否则sum就是结果了,条件比较长，我就抽出来写了
            boolean isRight = (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) && (month > 2);
            if (isRight) {
                sum += 1;
            }
            System.out.println(year + "年" + month + "月" + day + "日，是这年的第" + sum + "天");
        }
    }



【程序15】

题目：输入三个整数x,y,z，请把这三个数由小到大输出。

程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，然后再用x与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。

最后两个数也使z>y就可以了 

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview15 {
        public static void main(String[] args) {
            System.out.println("三个整数：");
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();//获取整数
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            int temp = 0;//最为一个交换数
            if (num1 > num2) {//保证num2>num1
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num1 > num3) {//保证num3>num1
                temp = num1;
                num1 = num3;
                num3 = temp;
            }
            if (num2 > num3) {//保证num3>num2
                temp = num2;
                num2 = num3;
                num3 = temp;
            }
            System.out.println("这三个数从小到大排列：" + num1 + "  " + num2 + "  " + num3);
            scanner.close();
        }
    }





【程序16】

题目：输出9*9口诀。

程序分析：分行与列考虑，共9行9列，i控制行，jC列。

表达式：  i+"*"+j+"="+i*j，这里要用两个for循环控制输出和换行

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview16 {
        public static void main(String[] args) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(i + "*" + j + "=" + i * j + " ");//输出结果
                }
                System.out.println();//换行
            }
        }
    }



【程序17】

题目：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。

程序分析：采取逆向思维的方法，从后往前推断。

天  数       1    2    3     4     5    。。。10

桃子数     1    4   10   22   46          ？

所以桃子数计算方法：前一天桃子数 * 2+2

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview17 {
        public static void main(String[] args) {
            int sum = 1;//第一天桃子的数量
            for (int i = 2; i <= 10; i++) {//第二天才开始计算
                sum = sum * 2 + 2;
            }
            System.out.println("猴子摘的桃子数为：" + sum);
        }
    }



【程序18】

题目：两个乒乓球队进行比赛，各出三人。甲队为a,b,c三人，乙队为x,y,z三人。已抽签决定比赛名单。有人向队员打听比赛的名单。a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。

程序分析：？？？感觉不能下手！ 

这道题目使用的是构造方法，还有arrayList的知识！标准答案的答案！

但是，还是被我用for循环给解决了

这里重要的是使用赋值，还有充分使用给出的条件，还有一个就是互不冲突的常识，比如第一个if的使用！

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview18 {
        public static void main(String[] args) {
            String a = null, b = null, c = null;//甲队成员
            String[] racer = {"x", "y", "z"};//乙队成员
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (i != j && i != k && j != k) {
                            a = racer[i];
                            b = racer[j];
                            c = racer[k];
                            if (!a.equals("x") && !c.equals("z") && !c.equals("x")) {
                                if (a.equals(racer[i]) && b.equals(racer[j]) && c.equals(racer[k])) {
                                    System.out.println("a的对手是：" + racer[i] + "，b的对手是：" + racer[j] + "，c的对手是：" + racer[k]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

 

【程序19】

题目：打印出如下图案（菱形）

   *

***

******

********

******

***

   *

程序分析：先把图形分成两部分来看待，前四行一个规律，后三行一个规律，

利用双重 for循环，第一层控制行，第二层控制列。

详细分析第一部分图形的规律：

1、这是一个等腰三角形，*的打印次数1、3、5、7等差数列

2、还要注意空格打印的 次数3、2、1、0逐渐递减

第二部分同理可得！   

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview19 {
        public static void main(String[] args) {
            //打印上面部分：
            int n = 4;
            for (int i = 0; i < n; i++) {  //控制行
                for (int k = 3 - i; k > 0; k--) { //控制*前面空格的输出
                    System.out.print(" ");
                }
                //输出符号，但不要换行
                for (int j = 0; j <= 2 * i; j++) {  //控制列
                    System.out.print("*");
                }
                //输出完符号马上换行
                System.out.println();
            }
            //打印下面部分
            n = 3;
            for (int i = n; i > 0; i--) {  //控制行
                for (int k = 3 - i + 1; k > 0; k--) { //控制*前面空格的输出,第一行要加空格
                    System.out.print(" ");
                }
                //输出符号，但不要换行
                for (int j = 0; j <= 2 * i - 2; j++) {  //控制列
                    System.out.print("*");
                }
                //输出完符号马上换行
                System.out.println();
            }
        }
    }



【程序20】

题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13... 求出这个数列的前20项之和。

程序分析：请抓住分子与分母的变化规律。分数：fraction

1、第一项是2/1

2、前面一项分子和分母相加的和，为下一项的分子

3、前面一项分子，为下一项的分母  

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview20 {
        public static void main(String[] args) {
            float up = 2;//分子
            float down = 1;//分母
            float fraction = up / down;//分数
            float temp = 0;//交换数
            float sum = 0;//总和
            for (int i = 0; i < 20; i++) { //前面20项
                sum += fraction;   //分数相加
                temp = up + down;//先把分子分母的和赋值给一个交换数，不能马上赋值给分子，因为分子的值下面还有用
                down = up;     //把分子的值赋值给下一下的分母
                up = temp;     //把交换数的值赋值给下一项分子
                fraction = up / down;//下一项的分数值
            }
            System.out.println("" + sum);
        }
    }



【程序21】

题目：求1+2!+3!+...+20!的和

程序分析：此程序只是把累加变成了累乘。

1、先求该项阶乘的值

2、累加求求

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview21 {
        public static void main(String[] args) {
            int sum = 0;//总和
            for (int i = 1; i <= 20; i++) {
                sum += factorial(i);//累加
            }
            System.out.println("" + sum);
        }
     
        //求阶乘的实现
        private static int factorial(int i) {
            //求阶乘
            int mult = 1;
            for (int j = 1; j <= i; j++) {
                mult *= j;
            }
            return mult;//返回阶乘结果
        }
    }



【程序22】

题目：利用递归方法求5!。

程序分析：递归公式：f(n)=n*f(n-1)

不断的调用方法，直到最小的值确定

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview22 {
        public static void main(String[] args) {
     
            System.out.println(Fact(5));//输出结果值
        }
     
        //递归方法求阶乘的具体代码
        private static int Fact(int i) {
            if (i == 1) {//1的阶乘为1
                return 1;
            }
            return i * Fact(i - 1);//不断回调
        }
    }



【程序23】

题目：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。问第4个人岁数，他说比第3个人大2岁。问第三个人，又说比第2人大两岁。问第2个人，说比第一个人大两岁。最后问第一个人，他说是10岁。请问第五个人多大？

程序分析：利用递归的方法，递归分为回推和递推两个阶段。要想知道第五个人岁数，需知道第四人的岁数，依次类推，推到第一人（10岁），再往回推。

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview23 {
        public static void main(String[] args) {
            System.out.println("第五个人的岁数：" + getAge(5, 2));
        }
     
        //递归方法求第五个人的岁数
        private static int getAge(int num, int ageMore) {
            if (num == 1) {//第一个人岁数为10
                return 10;
            }
            return getAge(num - 1, ageMore) + ageMore;//每上一个人岁数加2
        }
    }



【程序24】

题目：给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。

程序分析：创建一个五位数数的数组，把输入数字的每位数的值赋值到数组里面  

把输入 数字从个位起获取，并且每获取一次之后/10，这样就能分别获取十位百位千位了

把数字打印出来就是题目所求了 

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview24 {
        public static void main(String[] args) {
            System.out.println("请输入一个不大于5位数的数字：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();//获取输入
            int[] arr = new int[5];//创建5位数的数组
            int i = 0;
            //循环取位
            do {
                arr[i] = num % 10;
                num = num / 10;
                i++;
            } while (num != 0);//只剩下一位时，说明获取完毕，跳出循环
            System.out.println("输入数字串的是" + i + "位数的");
            System.out.println("逆序输出：");
            //打印出数组
            for (int j = 0; j < i; j++) {
                System.out.print(arr[j] + "  ");
            }
            scanner.close();
        }
    }



【程序25】

题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。

这个程序跟上一个程序类似。

创建一个五位数的数组 

逐次取位 

组后判断条件就可以了 

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview25 {
        public static void main(String[] args) {
            System.out.println("请输入一个五位数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();//获取输入的数字
            int arr[] = new int[5];//创建一个大小为5的数组
            int i = 4;
            do {//逐次取位
                arr[i] = input % 10;
                input /= 10;
                i--;
            } while (i >= 0);//这里的结束条件写input！=0也是可以的
            //System.out.println(Arrays.toString(arr));
            if (arr[0] == arr[4] && arr[1] == arr[3]) {
                System.out.println("输入的数是回文数字！");
            } else {
                System.out.println("输入的数不是回文数字！");
            }
            scanner.close();
        }
    }



【程序26】

题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。

程序分析：用情况语句比较好，如果第一个字母一样，则判断用情况语句或if语句判断第二个字母。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview26 {
        public static void main(String[] args) {
            System.out.println("请输入第一个英文字母：");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            String input2 = "";
            switch (input) {
                case "m":
                    System.out.println("Monday");
                    break;
                case "t":
                    System.out.println("请输入第二个字母：");
                    input2 = scanner.next();
                    if (input2.equals("u")) {
                        System.out.println("Tuesday");
                    } else if (input2.equals("h")) {
                        System.out.println("Thursday");
                    } else {
                        System.out.println("你输入的字母有误！");
                    }
                    break;
                case "w":
                    System.out.println("Wednesday");
                    break;
                case "f":
                    System.out.println("Friday");
                    break;
                case "s":
                    System.out.println("请输入第二个字母：");
                    input2 = scanner.next();
                    if (input2.equals("u")) {
                        System.out.println("Sunday");
                    } else if (input2.equals("a")) {
                        System.out.println("Saturday");
                    } else {
                        System.out.println("你输入的字母有误！");
                    }
                    break;
                default:
                    System.out.println("你输入的字母不正确！");
                    break;
            }
            scanner.close();
        }
    }



【程序27】

题目：求100之内的素数

素数的判断方法：这个数除以2到比它本身少1的数都不能整除，那么这个数就是素数了！ 

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview27 {
        public static void main(String[] args) {
            int sum = 0;
            for (int i = 2; i < 100; i++) {
                if (IsRight(i)) {//如果是素数就打印出来
                    System.out.print(i + "  ");
                    sum++;
                    if (sum % 10 == 0) {//十个一行
                        System.out.println();
                    }
                }
            }
            System.out.println("\n共有素数：" + sum + "个");
        }
     
        //判断该数是不是素数
        private static boolean IsRight(int i) {
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    return false;//不是素数的话，马上返回false
                }
            }
            return true;
        }
    }



【程序28】

题目：对10个数进行排序

程序分析：可以利用选择法，即从后9个比较过程中，选择一个最小的与第一个元素交换，下次类推，即用第二个元素与后8个进行比较，并进行交换。

最后打印出来的数组就是从小到大排列的数组了

    package com.aura.mazh.interview50;
     
    import java.util.Arrays;
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview28 {
        public static void main(String[] args) {
            System.out.println("请输入10个数（用空格隔开）：");
            int[] arr = new int[10];
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                arr[i] = scanner.nextInt();
            }
            //对数组进行排序
            int temp = 0;//交换数
            for (int i = 0; i < 9; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {  //如果第一个数比后面的数大就交换
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("排列后的数组：" + Arrays.toString(arr));//Arrays类的包装方法！
        }
    }



【程序29】

题目：求一个3*3矩阵对角线元素之和

程序分析：利用双重for循环控制输入二维数组，再将a[i][i]累加后输出。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview29 {
        public static void main(String[] args) {
            System.out.println("请输入九个数字：");
            Scanner scanner = new Scanner(System.in);
            int[][] arr = new int[3][3];
            //获取矩阵数字
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println("第一条对角线之和：" + (arr[0][0] + arr[1][1] + arr[2][2]));
            System.out.println("第二条对角线之和：" + (arr[0][2] + arr[1][1] + arr[2][0]));
            scanner.close();
        }
    }



【程序30】

题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。

程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后此元素之后的数，依次后移一个位置。

1、创建两个数组，如果插入的数字比数组最后一个都大，那么插入的数放在新数组最后就可以

2、如果插入的不是最大，那么和数组前面的数逐一比较，比较到比插入的数大就break

比如第i个符合条件，那么arrB[i-1]=arrA[i-1],arrB[i]=num,arrB[i+1]=arrA[i]

    package com.aura.mazh.interview50;
     
    import java.util.Arrays;
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview30 {
        public static void main(String[] args) {
            System.out.println("请输入一个数字：");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            int[] arrA = {3, 5, 15, 36, 84, 99};
            int[] arrB = new int[arrA.length + 1];
            if (num > arrA[arrA.length - 1]) {
                for (int i = 0; i < arrA.length; i++) {
                    arrB[i] = arrA[i];
                }
                arrB[arrB.length - 1] = num;
            } else {
                for (int i = 0; i < arrA.length; i++) {
                    if (num < arrA[i]) {
                        for (int j = 0; j < i; j++) {
                            arrB[j] = arrA[j];
                        }
                        arrB[i] = num;
                        for (int j = i; j < arrA.length; j++) {
                            arrB[j + 1] = arrA[j];
                        }
                        break;//这个很重要
                    }
                }
            }
            System.out.println("插入一个数后的数组为：" + Arrays.toString(arrB));
            scanner.close();
        }
    }



【程序31】

题目：将一个数组逆序输出。

程序分析：用第一个与最后一个交换。

    package com.aura.mazh.interview50;
    import java.util.Arrays;
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview31 {
        public static void main(String[] args) {
            int[] arrA = {1, 3, 44, 22, 77, 99};
            int[] arrB = new int[arrA.length];
            int j = arrA.length;
            for (int i = 0; i < arrA.length; i++) {
                arrB[i] = arrA[j - 1];
                j--;
            }
            System.out.println("数组A逆序输出为：" + Arrays.toString(arrB));
        }
    }



【程序32】

题目：取一个整数a从右端开始的4～7位。

程序分析：可以这样考虑：

看下面的详细解说

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview32 {
        public static void main(String[] args) {
            System.out.println("输入一个整数：");
            Scanner scanner = new Scanner(System.in);
            long num = scanner.nextLong();//获取输入
            String str = Long.toString(num);//把数字转化为String类型的
            char[] ch = str.toCharArray();//把String类型的字符，转化为char类型，每一个数字赋值到字符型数组中
            int n = ch.length;//字符型数组的长度
            System.out.println("该整数从右端开始的4-7位为：" + ch[n - 7] + ch[n - 6] + ch[n - 5] + ch[n - 4]);//输出结果
            scanner.close();//关闭输入流
        }
    }



【程序33】

题目：打印出杨辉三角形（要求打印出10行如下图）

程序分析：

        1
    
      1 1
    
     1 2 1

   1 3 3 1

  1 4 6 4 1

1 5 10 10 5 1

1、二维数组的使用

2、第一列的数都是1

3、使用两个for循环，i控制行，j控制列；

从第二行第二列起arr[i][j]=arr[i-1][j-1]+arr[i-1][j]

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview33 {
        public static void main(String[] args) {
            int[][] arr = new int[10][10];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 1;//控制第一列的数等于1
            }
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];//赋值
                }
            }
            //打印结果
            for (int i = 0; i < arr.length; i++) {
                for (int k = arr.length - i; k > 0; k--) {//空格的控制，为了好看
                    System.out.print("  ");
                }
                for (int j = 0; j < arr.length; j++) {//打印出数组的数字
                    if (arr[i][j] != 0) {//把把没赋值的零去掉
                        System.out.print(arr[i][j] + "   ");
                    }
                }
                System.out.println();//控制换行
            }
        }
    }



【程序34】

题目：输入3个数a,b,c，按大小顺序输出。

程序分析：利用指针方法。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview34 {
        public static void main(String[] args) {
            System.out.println("请输入三个数：");
            Scanner scanner = new Scanner(System.in);
            int num1 = scanner.nextInt();//获取输入的数
            int num2 = scanner.nextInt();
            int num3 = scanner.nextInt();
            scanner.close();
            int temp = 0;
            if (num1 > num2) {//确保num2>num1
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
            if (num1 > num3) {//确保num3>num1
                temp = num1;
                num1 = num3;
                num3 = temp;
            }
            if (num2 > num3) {//确保num3>num2
                temp = num2;
                num2 = num3;
                num3 = temp;
            }
            System.out.println("这三个数从大到小排列：" + num3 + "  " + num2 + "   " + num1);
        }
    }

 



【程序35】

题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组。

 程序分析：1、找到该数组的最大值和最小值

找到该数组最大项把它和第一位交换，

找到该数值的最小项把它和最后一项交换

这里有一点值得注意：不能把最大值和最小值先找出来，再连续执行两次操作交换，会出错！

还有一点要注意：没叫到要交换的数值的位置不变，我在网上查了的都会有乱序的

    package com.aura.mazh.interview50;
     
    import java.util.Arrays;
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview35 {
        public static void main(String[] args) {
            System.out.print("请输入一组数：");
            Scanner scan = new Scanner(System.in).useDelimiter("\\s");
            int[] arrA = new int[50];
            int m = 0;//数组的长度
            while (scan.hasNextInt()) {//不断给数组A赋值
                arrA[m++] = scan.nextInt();
            }
            scan.close();//关闭输入流
            int[] arrB = new int[m];//创建数组B，要求刚好适应输入的数字的个数
            for (int i = 0; i < m; i++) {
                arrB[i] = arrA[i];//把数组A不为零的数值赋值给数组B
            }
            int max = 0;
            int min = arrB[1];//定义数组的最小值
            for (int i = 0; i < arrB.length; i++) {
                if (arrB[i] > max) {//求数组的最大值
                    max = arrB[i];
                }
                if (arrB[i] <= min) {//求数组的最小值
                    min = arrB[i];
                }
            }
            int max_i = 0;//定义数组最大值的下标
            int min_i = 0;//定义数组最小值的下标
            for (int i = 0; i < arrB.length; i++) {
                if (max == arrB[i]) {
                    max_i = i;
                }
            }
            int temp = 0;//定义一个交换值
            //把最大的值和第一个值交换
            temp = arrB[0];
            arrB[0] = arrB[max_i];
            arrB[max_i] = temp;
            //求数组最小值的下标
            for (int i = 0; i < arrB.length; i++) {
                if (min == arrB[i]) {
                    min_i = i;
                }
            }
            //把最小的值和最后一个值交换
            temp = arrB[arrB.length - 1];
            arrB[arrB.length - 1] = arrB[min_i];
            arrB[min_i] = temp;
            System.out.println(Arrays.toString(arrB));
            scan.close();
        }
    }

 


【程序36】

题目：有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数

程序分析：在原来数组的基础上还要创建一个和原来数组大小一样的数组

根据要移动的位数把原来的数组分割成两个部分分别赋值给新的数组

    package com.aura.mazh.interview50;
     
    import java.util.Arrays;
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview36 {
        public static void main(String[] args) {
            System.out.println("输入一个十个数的组数：");
            Scanner scanner = new Scanner(System.in);
            int n = 10;
            int[] arrA = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = scanner.nextInt();//获取十个数组
            }
            System.out.println("没移动前的数组：" + Arrays.toString(arrA));
            System.out.println("请输入要往后移动的个数：");
            int m = scanner.nextInt();//获取输入往后退的个数
            m %= n;//十个相当于循环
            int[] arrB = new int[n];//创建和数组A大小一样的数组B
            int k = m;//创建一个可变的变量
            for (int i = m; i < arrA.length; i++) {
                arrB[i] = arrA[i - m];
            }
            for (int i = 0; i < m; i++) {
                arrB[i] = arrA[arrA.length - k];
                k--;
            }
            System.out.println("移动后的数组：" + Arrays.toString(arrB));//输出数组B
            scanner.close();
        }
    }



【程序37】

题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。

关键问题是怎么移除》？:布尔值确定，如果被选中被赋值为false

从第一个人开始判断，如果他在圈内，那么报数，再判断他报的数是否是3，如果是的话移出圈外

接着判断下一个人，是否到了最末，如果是的话，从零开始

不断循环，直到最后剩下1个人

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview37 {
        public static void main(String[] args) {
            System.out.print("请输入一个整数：");
            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            scan.close();
            //定义数组变量标识某人是否还在圈内
            boolean[] isIn = new boolean[n];
            for (int i = 0; i < isIn.length; i++) {
                isIn[i] = true;
            }
            int inCount = n;//定义圈内人数
            int countNum = 0;//定义报数
            int index = 0;//定义索引
            while (inCount > 1) {//最后一人时退出循环
                if (isIn[index]) {//判断下一个人是否在圈内
                    countNum++;//在的话报数
                    if (countNum == 3) {//如果这个数等于3
                        isIn[index] = false;//把他定义为出圈
                        countNum = 0;//报数清零，下一个好从1开始
                        inCount--;//圈内人数减一
                    }
                }
                index++;//下一人的位置索引值
                if (index == n) {//当索引到最后之后再从头开始
                    index = 0;
                }
            }
            for (int i = 0; i < n; i++) {
                if (isIn[i]) {//最后只有一个符合条件的
                    System.out.println("留下的是：" + (i + 1));
                }
            }
        }
    }



【程序38】

题目：写一个函数，求一个字符串的长度，在main函数中输入字符串，并输出其长度。

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview38 {
        public static void main(String[] args) {
            System.out.println("请输入一串字符：");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();//获取输入的字符串
            System.out.println("你输入的字符串是：" + input);
            System.out.println("你输入的字符串长度是：" + input.length());
            scanner.close();
        }
    }



【程序39】

题目：编写一个函数，输入n为偶数时，调用函数求1/2+1/4+...+1/n,当输入n为奇数时，调用函数1/1+1/3+...+1/n(利用指针函数)

程序分析：

1、先判断是奇数还是偶数

2、分数分子都是一，偶数分母从2开始，奇数的分母从1开始，分母差值都为2

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview39 {
        public static void main(String[] args) {
            System.out.println("请输入一个整数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            double sum = 0;//总和
            if (input % 2 == 0) {//偶数
                for (double i = 2; i <= input; i += 2) {
                    sum += 1 / i;
                    if (i == input) {
                        System.out.print("1/" + (int) i);//输出最后一项，最后用break，中断后面的执行
                        break;
                    }
                    System.out.print("1/" + (int) i + " + ");//输出相加的项后面加个加号
                }
            } else {//奇数情况
                for (double i = 1; i <= input; i += 2) {
                    sum += 1 / i;
                    if (i == input) {
                        System.out.print("1/" + (int) i);//输出最后一项，最后用break，中断后面的执行
                        break;
                    }
                    System.out.print("1/" + (int) i + " + ");//输出相加的项后面加个加号
                }
            }
            System.out.println(" = " + sum);
            scanner.close();
        }
    }





【程序40】

题目：字符串排序。

无语！这里要用一个封装的方法：booleanb=string1.compareTo(string2);

string1的类型值string2大于，则b是大于零，否者小于零

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview40 {
        public static void main(String[] args) {
            String[] str = {"abc", "cad", "m", "fa", "f"};
            for (int i = str.length - 1; i >= 1; i--) {
                for (int j = 0; j <= i - 1; j++) {
                    if (str[j].compareTo(str[j + 1]) < 0) {
                        String temp = str[j];
                        str[j] = str[j + 1];
                        str[j + 1] = temp;
                    }
                }
            }
            for (String subStr : str)
                System.out.print(subStr + " ");
        }
    }



【程序41】

题目：海滩上有一堆桃子，五只猴子来分。第一只猴子把这堆桃子凭据分为五份，多了一个，这只猴子把多的一个扔入海中，拿走了一份。第二只猴子把剩下的桃子又平均分成五份，又多了一个，它同样把多的一个扔入海中，拿走了一份，第三、第四、第五只猴子都是这样做的，问海滩上原来最少有多少个桃子？

程序分析：有个疑问就是题目没说第五个猴子拿到的只有一个桃子，但是别人都知道？？不理解

这其实就是一个递归问题每次*5 +1

这个用逆向思维

5     4      3     2      1     

桃子个数     6     31    156   781     3906

猴子拿的个数     1      6    31    156     781

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview41 {
        public static void main(String[] args) {
            System.out.println(peach(1));
        }
     
        private static int peach(int i) {
            if (i == 5) {
                return 6;
            }
            return peach(i + 1) * 5 + 1;
        }
    }



【程序42】

题目：809*??=800*??+9*??+1

其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。求??代表的两位数，及809*??后的结果。

程序解析：for循环的使用 

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview42 {
        public static void main(String[] args) {
            String result = "";
            for (int i = 100; i < 1000; i++) {
                if (809 * i == 800 * i + 9 * i + 1) {
                    result = i + " ";
                }
            }
            if (result.equals("")) {
                System.out.println("没有合适的数");
            } else {
                System.out.println("合适的数有：" + result);
            }
        }
    }



【程序43】

题目：求0—7所能组成的奇数个数。

程序分析：最少也是1位数，最多能组成8位的数字 

第一位不能为零，最后一位不能是偶数

0到7有四个奇数

这里用累加求和

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview43 {
        public static void main(String[] args) {
            int n = 8;//位数
            int sum = 0;//总和
            // 1位数情况
            sum += n / 2;
            // 2位数情况
            sum += (n - 1) * n / 2;
            // 3位数情况
            sum += (n - 1) * n * n / 2;
            // 4位数情况
            sum += (n - 1) * n * n * n / 2;
            // 5位数情况
            sum += (n - 1) * n * n * n * n / 2;
            // 6位数情况
            sum += (n - 1) * n * n * n * n * n / 2;
            // 7位数情况
            sum += (n - 1) * n * n * n * n * n * n / 2;
            // 8位数情况
            sum += (n - 1) * n * n * n * n * n * n * n / 2;
            System.out.println("0到7能组成的奇数个数：" + sum);
        }
    }



【程序44】

题目：一个偶数总能表示为两个素数之和。

程序分析：判断两个加数是不是素数

素数的判断前面做过很多了，不说了！ 

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview44 {
        public static void main(String[] args) {
            System.out.println("请输入一个偶数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            while (input % 2 != 0) {
                System.out.println("你输入的不是偶数，请重新输入：");
                input = scanner.nextInt();
            }
            for (int i = 2; i < input; i++) {
                if (isRightNum(i) && isRightNum(input - i)) {//两个加数同时是素数
                    System.out.println(input + "=" + i + "+" + (input - i));
                    break;
                }
            }
            scanner.close();
        }
     
        //判断这个数是不是素数的具体方法：
        private static boolean isRightNum(int i) {
            for (int j = 2; j < Math.sqrt(i + 1); j++) {
                if (i % j == 0) {//确定是素数
                    return false;
                }
            }
            return true;
        }
    }



【程序45】

题目：判断一个素数能被几个9整除

程序分析：这个题目也不知道是哪个傻瓜想出来的，我只能说垃圾，不知道它想问什么的？

下面是网上下的答案，我不想做！

我猜它是判断输入的数比9 的多少次方大？而且跟素数有毛关系？？

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview45 {
        public static void main(String[] args) {
            System.out.print("请输入一个数：");
            Scanner scan = new Scanner(System.in);
            long l = scan.nextLong();
            long n = l;
            scan.close();
            int count = 0;
            while (n > 8) {
                n /= 9;
                count++;
            }
            System.out.println(l + "能被" + count + "个9整除。");
        }
    }



【程序46】

题目：两个字符串连接程序

程序分析：考察程序的基本常识吗？

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview46 {
        public static void main(String[] args) {
            String str1 = "lao lee";
            String str2 = "牛刀";
            String str = str1 + str2;
            System.out.println(str);
        }
    }



【程序47】

题目：读取7个数（1—50）的整数值，每读取一个值，程序打印出该值个数的＊。

程序分析：简单方法的调用而已！

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview47 {
        public static void main(String[] args) {
            System.out.print("请输入7个整数(1-50)：");
            Scanner scan = new Scanner(System.in);
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int n3 = scan.nextInt();
            int n4 = scan.nextInt();
            int n5 = scan.nextInt();
            int n6 = scan.nextInt();
            int n7 = scan.nextInt();
            scan.close();
            printStar(n1);
            printStar(n2);
            printStar(n3);
            printStar(n4);
            printStar(n5);
            printStar(n6);
            printStar(n7);
        }
     
        static void printStar(int m) {
            System.out.print(m);
            for (int i = 0; i < m; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }



【程序48】

题目：某个公司采用公用电话传递数据，数据是四位的整数，在传递过程中是加密的，加密规则如下：每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换。

程序分析：

1、数字取位，个十百千位分别求出

2、按要求替换

3、按要求交换

    package com.aura.mazh.interview50;
     
    import java.util.Scanner;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview48 {
        public static void main(String[] args) {
            int[] num = new int[4];//存放四位数的个十百千位
            System.out.println("请输入一个四位数：");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            for (int i = 0; i < 4; i++) {//逐次取位，从个位开始,并按要求替换
                num[i] = (input % 10 + 5) % 10;
                input /= 10;
            }
            //按要求替换,交换1、4位
            int temp = 0;//交换数
            temp = num[0];
            num[0] = num[3];
            num[3] = temp;
            //交换2、3位
            temp = num[1];
            num[1] = num[2];
            num[2] = temp;
            System.out.println("加密后的结果：" + num[3] + num[2] + num[1] + num[0]);
            scanner.close();
        }
    }



【程序49】

题目：计算字符串中子串出现的次数

程序分析：

把string类型的字符串的每个元素，转换为char数组里面的每个数组的值string.toCharArray()

判断char数组中是否存在空格，存在的话子字符串数量加1

    package com.aura.mazh.interview50;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview49 {
        public static void main(String[] args) {
            String string = "aa bb df 23 d 3 df32 d";
            int num = 1;//子字符的数量
            char[] c = string.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == ' ') {
                    num++;
                }
            }
            System.out.println(string + "有子字符串： " + num + " 个");
        }
    }



【程序50】

题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。

最后这题涉及文件存储，输入输出流

    package com.aura.mazh.interview50;
     
    import java.io.*;
     
    /**
     * @Auther: 马中华 ： https://blog.csdn.net/zhongqi2513
     * @Date: 2019/6/16 07:19
     * @Description:
     */
    public class Interview50 {
        //定义学生模型
        String[] number = new String[5];
        String[] name = new String[5];
        float[][] grade = new float[5][3];
        float[] sum = new float[5];
     
        public static void main(String[] args) throws Exception {
            Interview50 stud = new Interview50();
            stud.input();
            stud.output();
        }
     
        //输入学号、姓名、成绩
        void input() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //录入状态标识
            boolean isRecord = true;
            while (isRecord) {
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print("请输入学号：");
                        number[i] = br.readLine();
                        System.out.print("请输入姓名：");
                        name[i] = br.readLine();
                        for (int j = 0; j < 3; j++) {
                            System.out.print("请输入第" + (j + 1) + "门课成绩：");
                            grade[i][j] = Integer.parseInt(br.readLine());
                        }
                        System.out.println();
                        sum[i] = grade[i][0] + grade[i][1] + grade[i][2];
                    }
                    isRecord = false;
                } catch (NumberFormatException e) {
                    System.out.println("请输入一个数字！");
                }
            }
        }
     
        //输出文件
        void output() throws IOException {
            FileWriter fw = new FileWriter("E://java50//stud.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("No.  " + "Name  " + "grade1  " + "grade2  " + "grade3  " + "average");
            bw.newLine();
            for (int i = 0; i < 5; i++) {
                bw.write(number[i]);
                bw.write("  " + name[i]);
                for (int j = 0; j < 3; j++)
                    bw.write("  " + grade[i][j]);
                bw.write("  " + (sum[i] / 5));
                bw.newLine();
            }
            bw.close();
        }
    }
