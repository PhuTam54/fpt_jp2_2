package java63_queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {
    public static void main(String[] args) {
        Deque<String> danhSachSV = new ArrayDeque<>();
        danhSachSV.offer("Phu Tam");
        danhSachSV.offer("Tran Thuy");
        danhSachSV.offerLast("TT");
        danhSachSV.offer("Phu Tam 2");
        danhSachSV.offerFirst("PT");


        while (true) {
            String ten = danhSachSV.pollFirst(); // peek lay ten ra khong xoa
            if (ten == null) break;
            System.out.println(ten);
        }
    }
}
