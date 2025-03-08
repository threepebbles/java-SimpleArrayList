import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ListStudy {
    @Test
    public void arrayList() {
        SimpleList<String> values = new SimpleArrayList<>();
        values.add("first");
        values.add("second");

        assertThat(values.add("third")).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo("first"); // 첫 번째 값을 찾는다.
        assertThat(values.contains("first")).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo("first"); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.

        // TODO: values에 담긴 모든 값을 출력한다.
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    @Test
    void mission1() {
        SimpleList<Integer> values = new SimpleArrayList<>();
        values.add(1);
        values.add(2);

        assertThat(values.add(3)).isTrue(); // 세 번째 값을 추가한다.
        assertThat(values.size()).isEqualTo(3); // list의 크기를 구한다.
        assertThat(values.get(0)).isEqualTo(1); // 첫 번째 값을 찾는다.
        assertThat(values.contains(1)).isTrue(); // "first" 값이 포함되어 있는지를 확인한다.
        assertThat(values.remove(0)).isEqualTo(1); // 첫 번째 값을 삭제한다.
        assertThat(values.size()).isEqualTo(2); // 값이 삭제 됐는지 확인한다.
        
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    @Test
    void mission2() {
        final String[] arrays = {"first", "second"};
        final SimpleList<String> values = SimpleList.<String>fromArrayToList(arrays);
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
    }

    @Test
    void mission3() {
        final SimpleList<Double> doubleValues = new SimpleArrayList<Double>(0.5, 0.7);
        final SimpleList<Integer> intValues = new SimpleArrayList<Integer>(1, 2);

        final double doubleTotal = SimpleList.sum(doubleValues); // 1.2
        final double intTotal = SimpleList.sum(intValues);  // 3
        System.out.println(doubleTotal);
        System.out.println(intTotal);
    }
}
