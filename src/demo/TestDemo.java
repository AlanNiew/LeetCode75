package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niu
 * @date 2026-03-28
 */
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (Integer i : list) {
            if (i==5){
                list.remove(i);
            }
        }
    }
}
