package java63_queue;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<String> danhSachSV = new LinkedList<String>();
        danhSachSV.offer("Phu Tam");
        danhSachSV.offer("Tran Thuy");
        danhSachSV.offer("Phu Tam 2");

        while (true) {
            String ten = danhSachSV.poll(); // peek lay ten ra khong xoa
            if (ten == null) break;
            System.out.println(ten);
        }
    }
}
