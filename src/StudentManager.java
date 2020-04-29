import javax.swing.plaf.BorderUIResource;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentManager {



    public static  final int SIZE = 20;
    Student[] students = new Student[SIZE];
    int count = 0;


    public StudentManager()
    {

        Scanner scan = new Scanner(System.in);
        printMenu();

        while(true)
        {
            //读取用户输入
            int choice = scan.nextInt();

            if(choice == 6){
                System.out.println("成功退出系统，欢迎再次使用！");
                break;
            }
            switch(choice)
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    findStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    //修改信息
                    break;
                case 5:
                    printAllStudent();
                    break;
                case 0:
                    printMenu();
                    break;


            }


        }


    }

    void printMenu()
    {
        //打印菜单
        System.out.println("请选择操作：");
        System.out.println("********************************");
        System.out.println("* 1 插入 *");
        System.out.println("* 2 查找 *");
        System.out.println("* 3 删除 *");
        System.out.println("* 4 修改 *");
        System.out.println("* 5 输出 *");
        System.out.println("* 6 退出 *");
        System.out.println("********************************");


    }

    void addStudent()
    {
        //插入学生信息
        if(count < SIZE)
        {
            System.out.println("当前共有"+count+"个学生信息");
            Scanner scan = new Scanner(System.in);
            System.out.println("请输入学号：");
            int ID = scan.nextInt();
            System.out.println("请输入姓名：");
            String name = scan.next();
            System.out.println("请输入出生年月：xx/xx/xx(年/月/日)");
            String birDate = scan.next();
            System.out.println("请输入性别：男/女");
            String gender = scan.next();

            Student student = new Student(ID,name,birDate,gender);
            students[count] = student;
            count++;
            System.out.println("添加成功！");
            sortStu();//对新列表进行排序
        }
        else
        {
            System.out.println("学生名单已满，无法添加！");
        }
        System.out.println("返回主界面请按“0”");
    }

    void deleteStudent()
    {
        //删除学生信息
        Scanner scan = new Scanner(System.in);
        {
            System.out.println("请输入要删除的学生信息的学生姓名：");
            String name = scan.next();
            int id = nameFind(name);
            if (id > -1) {
                for (int i = id; i < count - 1; i++) {
                    students[i] = students[i + 1];
                }
                count--;
                System.out.println("删除成功！");
                sortStu();//删除后排序
            } else {
                System.out.println("未找到您想要的学生姓名！");
            }
            System.out.println("返回主界面请按“0”");
        }

    }


    int nameFind(String name)
    {
        //姓名查找
        int id = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getName().equals(name)) {
                id = i;
                break;
            }
        }
        return id;
    }

    void findStudent()
    {
        //学生信息查找
        Scanner scan = new Scanner(System.in);

        {
            System.out.println("请输入要查找的学生姓名");
            String name = scan.next();
            int id = nameFind(name);
            if (id > -1)
            {
                System.out.print("查找成功！信息如下：");
                printStudent(students[id]);
            }
            else
            {
                System.out.println("未找到该学生信息！");
            }
            System.out.println("返回主界面请按“0”");
        }
    }

    void printAllStudent()
    {
        //输出所有学生信息
        for (int i = 0; i < count; i++)
        {
            System.out.println((i+1)+" ID："+students[i].getID()+" 姓名："+students[i].getName()+" 出生日期："+students[i].getBirDate()+" 性别："+students[i].getGender());
        }
        System.out.println("返回主界面请按“0”");
    }

    void printStudent(Student stu1)
    {
        //某个学生信息输出
        System.out.println(" ID："+ stu1.getID()+" 姓名："+stu1.getName()+" 出生日期："+stu1.getBirDate()+" 性别："+stu1.getGender());

    }

    void sortStu()
    {
        //对学生列表进行排序
        int l = count - 1;
        Student temp = new Student();
        for (int j = 0; j < l; j++) {
            for (int i = 0; i < l - j; i++) {
                // 依次比较相邻的两个元素,使较大的那个向后移
                if(students[i].getID() > students[i+1].getID())
                {
                    temp = students[i];
                    students[i] = students[i+1];
                    students[i+1] = temp;
                }
            }
        }
    }
}
