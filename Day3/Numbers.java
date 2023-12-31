package Day3;

import java.util.List;

public class Numbers {

    public static Integer sumIntegerArray(List<Integer> numberList) {
        Integer s = 0;
        for (Integer n : numberList) {
            s += n;
        }

        return s;
    }

    public static Float sumFloatArray(List<Float> numberList) {
        Float s = 0f;
        for (Float n : numberList) {
            s += n;
        }
        return s;
    }
}