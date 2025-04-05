# 미션

```java
public interface SimpleList {

    boolean add(String value);

    void add(int index, String value);

    String set(int index, String value);

    String get(int index);

    boolean contains(String value);

    int indexOf(String value);

    int size();

    boolean isEmpty();

    boolean remove(String value);

    String remove(int index);

    void clear();
}
```

## 미션1

```java
SimpleList<Integer> values=new SimpleArrayList<Integer>();
values.add(1);
values.add(2);

Integer first=values.get(0);
Integer second=values.get(1);
```

제네릭을 사용하여 String 이외의 타입도 다룰 수 있도록 만든다.

## 미션2

```java
final String[]arrays={"first","second"};

final SimpleList<String> values=SimpleList.<String>fromArrayToList(values);
```

배열을 받아 SimpleList로 변환하는 메서드를 구현해본다.

## 미션3

```java
final SimpleList<Double> doubleValues=new SimpleArrayList<Double>(0.5,0.7);
final SimpleList<Integer> intValues=new SimpleArrayList<Integer>(1,2);

final double doubleTotal=SimpleList.sum(doubleValues); // 1.2
final double intTotal=SimpleList.sum(intValues);  // 3
```

숫자 타입의 SimpleList를 받아 모든 값을 더해주는 메서드를 구현해본다.
String과 같은 숫자가 아닌 타입이 들어올 경우 예외가 발생해야 한다.

## 미션4

```java
final SimpleList<Double> doubleValues=new SimpleArrayList<Double>(-0.1,0.5,0.7);
final SimpleList<Integer> intValues=new SimpleArrayList<Integer>(-10,1,2);

final SimpleList<Double> filteredDoubleValues=SimpleList.filterNegative(doubleValues);
final SimpleList<Integer> filteredIntValues=SimpleList.filterNegative(intValues);
```

숫자 타입의 SimpleList를 받아 음수를 제외하고 반환하는 메서드를 구현해본다.

## 미션5

```java
class Printer {
}

class LaserPrinter extends Printer {
}

---

final var laserPrinter=new LaserPrinter();

final SimpleList<Printer> printers=new SimpleArrayList<Printer>();
final SimpleList<LaserPrinter> laserPrinters=new SimpleArrayList<LaserPrinter>(laserPrinter);

        SimpleList.copy(lazerPrinters,printers);

        System.out.println(printers.get(0)==laserPrinter); // true
```

리스트의 값을 다른 리스트로 복사하는 메서드를 구현해본다.
해당 메서드는 같은 타입이 아닌 상속 관계의 타입도 복사가 가능해야 한다.