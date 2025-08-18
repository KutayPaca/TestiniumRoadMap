# Java’da Array ve List’ler, Collections Framework’e Giriş

## 1. JDK 1.2 Öncesi Durum  
Java’da nesneleri gruplamak için önceleri **Array (dizi)**, **Vector** ve **Hashtable** kullanılıyordu. Ancak her biri farklı şekilde uygulanmıştı ve bu durum:

- Kullanımı tutarsız hale getiriyordu,  
- Öğrenmeyi ve kodun bakımını zorlaştırıyordu.

---
## 2. Eski Koleksiyon Örneği

```java
import java.util.*;

class CollectionDemo {
    public static void main(String[] args)
    {
        int arr[] = new int[] { 1, 2, 3, 4 };
        Vector<Integer> v = new Vector<>();
        Hashtable<Integer, String> h = new Hashtable<>();

        v.addElement(1);
        v.addElement(2);

        h.put(1, "geeks");
        h.put(2, "4geeks");

        System.out.println(arr[0]);         // 1
        System.out.println(v.elementAt(0)); // 1
        System.out.println(h.get(1));       // geeks
    }
}
java'''
```

- **Array:** Sabit uzunluklu bir dizi, hızlı erişim sağlar.  
- **Vector:** Dinamik büyüyen, ancak **synchronized** (thread-safe) bir dizi yapısıdır.  
- **Hashtable:** Anahtar-değer (key-value) çiftlerini tutan, thread-safe bir yapı.

---

## 3. Java Collection Framework Neler Getirdi?

JDK 1.2 ile birlikte **Java Collection Framework** tanıtıldı. Bu framework, yukarıdaki yapıların tutarsızlıklarını giderdi, ortak ve tutarlı arayüzler (interface) sundu:

- **List arayüzünü implement edenler:**  
  - `ArrayList`  
  - `LinkedList`  
  - `Vector`

- **Set arayüzünü implement edenler:**  
  - `HashSet`  
  - `LinkedHashSet`  
  - `TreeSet`

- **Map arayüzünü implement edenler:**  
  - `HashMap`  
  - `LinkedHashMap`  
  - `TreeMap`  
  - `Hashtable` (eski ama hala var)

---

## 4. Java Collection Framework Temel Arayüzleri

| Arayüz         | Açıklama                                   | Örnek Sınıflar                  |
| -------------- | ------------------------------------------ | ------------------------------- |
| **Iterable**   | Koleksiyon üzerinde gezinmeyi sağlar.      | Tüm koleksiyonlar               |
| **Collection** | Ortak metodları tanımlar (add, remove).    | List, Set                       |
| **List**       | Sıralı, tekrar eden elemanlara izin verir. | ArrayList, LinkedList, Vector   |
| **Set**        | Sırasız, benzersiz elemanlar içerir.       | HashSet, LinkedHashSet, TreeSet |
| **Map**        | Anahtar-değer ilişkisi tutar.              | HashMap, TreeMap, Hashtable     |

---

## 5. ArrayList ve LinkedList Karşılaştırması

| Özellik          | ArrayList                      | LinkedList                   |
| ---------------- | ------------------------------ | ---------------------------- |
| Veri Yapısı      | Dinamik dizi (array tabanlı)   | Bağlı liste (node zinciri)   |
| Eleman Ekleme    | Sonda hızlı, ortada yavaş      | Her yerde hızlı              |
| Eleman Silme     | Kaydırma gerektiği için yavaş  | Her yerde hızlı              |
| Eleman Erişimi   | Hızlı (indeksle direkt erişim) | Yavaş (baştan sırayla arama) |
| Hafıza Kullanımı | Daha az (yan yana depolar)     | Daha fazla (referanslar var) |

---

## 6. Vector Nedir?

- `Vector`, `ArrayList`’e çok benzer, dinamik büyüyen bir dizidir.  
- Ancak tüm metotları **synchronized** olduğundan, **thread-safe**’dir.  
- Çoklu iş parçacığı (thread) ortamlarında güvenle kullanılabilir.  
- Senkronizasyon, performansı bir miktar düşürür.  
- Modern Java’da, thread safety gerektiğinde genellikle farklı yapılar tercih edilir (`Collections.synchronizedList()`, `CopyOnWriteArrayList`).

---

## 7. Map Nedir?

Java'da **Map**, anahtar-değer çiftlerini saklayan bir veri yapısıdır. Anahtarlar benzersizdir ve her anahtar bir değere karşılık gelir.

### Avantajları
- Hızlı veri erişimi sağlar.
- Anahtar-değer ilişkisini gerçek dünyaya uygun şekilde modeller.
- Farklı türde anahtar ve değer kullanılabilir.

### Dezavantajları
- Bellek kullanımı yüksektir.
- Hash çakışmaları performansı etkileyebilir.
- Bazı implementasyonlar sıralama garantisi vermez.
- Thread-safe değildir, çoklu iş parçacığında sorun çıkabilir.

---

## Map Veri Tipinin Türü ve Diğerlerine Göre Farkı

Java'da Map, `Collection` arayüzünün bir parçası değildir.  
Map, anahtar-değer çiftlerini tutan ayrı bir arayüzdür (`java.util.Map`).  

- List, Set ve Queue gibi yapılar sıralı veya sırasız tek bir veri kümesi tutarken,  
- Map, her anahtara karşılık gelen bir değer saklar ve anahtarlar benzersizdir.  
- Dolayısıyla Map, indeksleme veya sıralama değil, anahtarla erişim mantığına dayalıdır.

Bu yönüyle Map, diğer veri yapılarından farklı bir tür data type olarak kabul edilir.

---

## 7. Kısa Özet

| Yapı           | Özellik                                      | Kullanım Alanı                                                          |
| -------------- | -------------------------------------------- | ----------------------------------------------------------------------- |
| **Array**      | Sabit uzunluklu, hızlı erişim                | Sabit boyutlu veri tutmak için                                          |
| **ArrayList**  | Dinamik, hızlı erişim, sıralı, tekrar eleman | Tek iş parçacıklı veya thread-safe olmayan durumlar için                |
| **LinkedList** | Dinamik, hızlı ekleme/silme, yavaş erişim    | Çok ekleme/silme olan durumlar                                          |
| **Vector**     | Dinamik, synchronized (thread-safe)          | Çoklu thread ortamlarında, ancak günümüzde alternatifleri tercih edilir |
| **Map**        | Anahtar-değer çiftleri, hızlı erişim         | Benzersiz anahtar-değer ilişkisi gereken durumlar; örn. veri tabanı önbelleği, konfigürasyon verileri |

---
# Java String Sınıfı (java.lang.String)

**Kısa Özet:**  
`String` immutable’dır (değiştirilemez). Bir String üzerinde değişiklik yaptığında aslında yeni bir String oluşur, orijinali aynı kalır. Bu yüzden çok sayıda değişiklik gerektiğinde **`StringBuilder`** kullanmak daha performanslıdır.

---

## 1. Temel Metodlar

```java
public class StringExamples {
    public static void main(String[] args) {
        String s = "  Hello.World  ";
        System.out.println("original: '" + s + "'");                 // '  Hello.World  '
        System.out.println("length: " + s.length());                 // 14 (boşluklar dahil)
        System.out.println("charAt(2): " + s.charAt(2));             // 'H'
        System.out.println("substring(2,7): '" + s.substring(2,7) + "'"); // "Hello"
        System.out.println("trim(): '" + s.trim() + "'");            // "Hello.World"
        System.out.println("toUpperCase(): " + s.toUpperCase());     // "  HELLO.WORLD  "
    }
}
```

> **Not:** `substring(begin, end)` → `end` **exclusive**. Index hatası için `IndexOutOfBoundsException` oluşur.

---

## 2. Arama ve Karşılaştırma

```java
String t = "abracadabra";
System.out.println(t.indexOf("bra"));      // 1
System.out.println(t.lastIndexOf("bra"));  // 8
System.out.println(t.indexOf('z'));        // -1
System.out.println(t.contains("cada"));    // true
System.out.println(t.startsWith("abra"));  // true
System.out.println(t.endsWith("bra"));     // true
```

---

## 3. equals vs ==

```java
String a = "abc";
String b = "abc";
String c = new String("abc");
System.out.println(a == b);       // true (string pool)
System.out.println(a == c);       // false (farklı nesne)
System.out.println(a.equals(c));  // true (içerik karşılaştırması)
```

> **Kural:** `==` referans karşılaştırır, içerik karşılaştırmak için `equals()` kullan.

---

## 4. replace, replaceAll, replaceFirst

```java
String s2 = "1.2.3";
System.out.println(s2.replace(".", "!"));         // "1!2!3"  -> literal
System.out.println(s2.replaceAll("\\.", "!"));    // "1!2!3"  -> regex (nokta escape edildi)
System.out.println("abc".replaceAll(".", "!"));   // "!!!" -> "." regex'te tüm karakterler demek
```

> **Not:** `replaceAll` regex kullanır. Literal string için `replace()` kullanmak daha güvenlidir.

---

## 5. split() ve limit parametresi

```java
String csv = "a,b,,c,";
String[] partsDefault = csv.split(",");     // Son boş stringleri atar
String[] partsKeep = csv.split(",", -1);    // Boş stringleri korur
```

> **Not:** `split` parametresi regex'tir. Nokta ile ayırmak için `split("\\.")` kullan.

---

## 6. isEmpty() vs isBlank() (Java 11+)

```java
String empty = "";
String spaces = "   ";
System.out.println(empty.isEmpty());   // true
System.out.println(spaces.isEmpty());  // false
System.out.println(spaces.isBlank());  // true (sadece whitespace ise)
```

---

## 7. StringBuilder Kullanımı (Performans)

```java
// Kötü yöntem (yavaş)
String bad = "";
for (int i = 0; i < 10000; i++) {
    bad += i + ",";
}

// İyi yöntem
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i).append(',');
}
String good = sb.toString();
```

> **Not:** `StringBuffer` thread-safe versiyondur ama yavaştır, çoğu durumda `StringBuilder` tercih edilir.

---

## 8. Regex ile Kullanım İpuçları

- `replaceAll` ve `split` regex kullanır.  
- Literal stringler için `Pattern.quote(literal)` veya `replace()` kullanmak güvenlidir.  
- `matches()` tüm stringi kontrol eder (başlangıçtan sona).

---

Math Sınıfı (java.lang.Math)
============================

**Kısa özet:** Tüm metodlar `static`. Hesaplar, trig, yuvarlama, rastgele (sınırlı) vs. `Math.random()` basit kullanım için, ama daha kontrollü rasgele için `Random` / `ThreadLocalRandom` kullan.

Sabitler ve basit metodlar
--------------------------

```java

`System.out.println(Math.PI);   // 3.141592653589793
System.out.println(Math.E);    // 2.718281828459045
System.out.println(Math.abs(-5));  // 5
System.out.println(Math.max(3,7)); // 7
System.out.println(Math.min(3,7)); // 3`

```

Yuvarlama: floor / ceil / round
-------------------------------

```java

`System.out.println(Math.floor(3.9));   // 3.0  (double)
System.out.println(Math.ceil(3.1));    // 4.0  (double)
System.out.println(Math.round(3.5));   // 4    (long)  // Math.round(double) -> long
System.out.println(Math.round(3.5f));  // 4    (int)   // Math.round(float) -> int
System.out.println(Math.round(-1.5));  // -1   (dikkat negatiflerde davranış)`

```

**Dikkat:** `round(double)` → `long`, `round(float)` → `int`. Negatif sayılarda `round` davranışı `floor(x+0.5)` mantığına göre.

* * * * *

Üs, kök, hypot
--------------

```java

`System.out.println(Math.pow(2,10));   // 1024.0
System.out.println(Math.sqrt(2));     // 1.4142135...
System.out.println(Math.hypot(3,4));  // 5.0  (daha güvenli: overflow/underflow riski azaltılır)`

```

Math.hypot` -> güvenli hipotenüs hesaplama (ara karelerin overflow riskini azaltır).

* * * * *

Trig
---------------------

```java

`double deg = 30;
double rad = Math.toRadians(deg);
System.out.println(Math.sin(rad));  // ~0.5 (küçük floating hata olabilir)`

````

**Tuzak:** trig fonksiyonları radyan ister; `Math.toRadians()` kullan.

* * * * *

Math.random() --- range oluşturma
-------------------------------

`Math.random()` -> `double` [0.0, 1.0)

```java


`// rastgele int [min, max] inclusive
int min = 5, max = 10;
int r = min + (int)(Math.random() * (max - min + 1));`

```

**NOT:** Bu yeterli ve basit, ama üretim kodunda `ThreadLocalRandom.current().nextInt(min, max + 1)` kullansan daha iyi (performans ve kalite).\
Örnek:

```java

`int r2 = java.util.concurrent.ThreadLocalRandom.current().nextInt(min, max + 1);`

```

* * * * *

NaN, Infinity, overflow
-----------------------

```java

`System.out.println(Math.sqrt(-1));           // NaN
System.out.println(Math.log(0));             // -Infinity
System.out.println(Math.pow(10, 400));       // Infinity (overflow)`

```

Her zaman sonuçları kontrol et (isFinite/isNaN) özellikle kullanıcı girdileri ya da büyük üslerde.

* * * * *

Kullanım tavsiyeleri / tuzaklar
-------------------------------

-   **Kesin yuvarlama (para vb.)** gerekiyorsa `BigDecimal` kullan; `double` hata verebilir.

-   Büyük üslerle çalışırken `Math.pow` -> çabuk `Infinity` olabilir. `Math.scalb`, `BigDecimal` veya mantıksal teknikler düşün.

-   Rastgele sayı üretiminde `Math.random()` paralel uygulamalarda yetersiz; `ThreadLocalRandom` veya `SecureRandom` (kripto) kullan.

Java Class ve Constructor Yapıları
==================================

* * * * *

1\. Class Nedir?
----------------

-   Java'da **class**, nesne tabanlı programlamanın temel taşıdır.

-   İçinde **field** (değişken), **method** (fonksiyon), **constructor** (yapıcı metod) barındırır.

-   Class bir şablon (template), nesnelerin (objects) blueprint'idir.

-   Java'da her şey class içinde olur.

-   Class'lar dosya isimleriyle aynı olmak zorunda değildir ama **public class**'lar için dosya adı ile class adı aynı olmalı.

### Basit Class Örneği

```java


`public class Araba {
    // field
    String renk;
    int hiz;

    // method
    void hizlan() {
        hiz += 10;
    }
}`

```

* * * * *

2\. Constructor Nedir?
----------------------

-   Constructor, class'tan nesne yaratılırken (instantiate) otomatik çalışan özel bir metottur.

-   Nesneyi ilk haline (initialize) getirmek için kullanılır.

-   Constructor adı **class ismi ile aynıdır** ve dönüş tipi **yoktur** (void bile yazılmaz).

-   Eğer sen constructor yazmazsan, Java sana **parametresiz default constructor** verir.

-   Bir class'da **birden fazla constructor (constructor overloading)** olabilir.

* * * * *

3\. Constructor Örnekleri
-------------------------

```java

`public class Araba {
    String renk;
    int hiz;

    // Parametresiz constructor (default)
    public Araba() {
        renk = "Beyaz";
        hiz = 0;
    }

    // Parametreli constructor
    public Araba(String renk, int hiz) {
        this.renk = renk;   // this. ile field'ı belirtiriz
        this.hiz = hiz;
    }

    void hizlan() {
        hiz += 10;
    }
}`

```

* * * * *

4\. Constructor Kullanımı
-------------------------

```java


`public class Main {
    public static void main(String[] args) {
        Araba araba1 = new Araba();                  // Parametresiz constructor çağrıldı
        Araba araba2 = new Araba("Kırmızı", 50);    // Parametreli constructor çağrıldı

        System.out.println(araba1.renk); // Beyaz
        System.out.println(araba2.renk); // Kırmızı

        araba2.hizlan();
        System.out.println(araba2.hiz);  // 60
    }
}`

```

* * * * *

5\. Ekstra Notlar
-----------------

-   Constructor içinde başka constructor çağırmak için `this()` kullanılır.

-   Eğer constructor içinde `this()` varsa, o çağrı **ilk satırda** olmalı.

-   **static** keyword'ü constructor'da kullanılamaz.

Java'da static ve final Keyword'leri
====================================

* * * * *

1\. `static` Nedir?
-------------------

-   `static` olan bir şey **class seviyesindedir**, nesneye değil.

-   Yani o değişken veya metod, **tüm nesneler için ortak**dır, tek bir kopyası olur.

-   Nesne oluşturmadan da **class adıyla erişilebilir** (`ClassName.staticMember`).

-   Genellikle yardımcı (utility) metotlar ve ortak veriler için kullanılır.

### Örnek:

```java

KopyalaDüzenle

`public class Sayac {
    public static int sayi = 0;

    public Sayac() {
        sayi++;   // Her nesne oluşturulunca sayi artar
    }
}

public class Main {
    public static void main(String[] args) {
        new Sayac();
        new Sayac();
        System.out.println(Sayac.sayi);  // 2 (Nesne sayısı)
    }
}`

```

* * * * *

2\. `final` Nedir?
------------------

-   `final` ile işaretlenen değişken veya metod ya da sınıf **değiştirilemez/override edilemez**.

-   Bir kere değer atanır, sonra değiştirilemez.

-   `final` değişkenler **sabit (constant)** gibi kullanılır.

-   `final` metodlar **alt sınıflarda override edilemez**.

-   `final` sınıf **extend edilemez** (miras alınamaz).

### Örnek:

```java

`public class Sabitler {
    public static final double PI = 3.14159;
}`

```

```java

`public final class SonSinif {
    // Bu sınıf miras alınamaz
}`

```

```java

`public class UstSinif {
    public final void metod() {
        System.out.println("Değiştirilemez metod");
    }
}

public class AltSinif extends UstSinif {
    // public void metod() { }  // Hata! override edilemez
}`

```

* * * * *

3\. `static final` Birlikte
---------------------------

-   Genellikle sabitleri tanımlamak için kullanılır.

-   `public static final` değişkenler **SABİT** olarak kabul edilir, isimleri genelde **büyük harf** ve `_` ile yazılır.

### Örnek:

```java

KopyalaDüzenle

`public class Fizik {
    public static final double IYI_HIZ = 299792458; // m/s (ışık hızı)
}`

```

* * * * *

4\. Dikkat Edilmesi Gerekenler
------------------------------

-   `static` metodlar **instance (nesne) değişkenlerine doğrudan erişemez** çünkü nesneye bağlı değildirler.

-   `final` değişken mutlaka **ilk atamada veya constructor'da bir kere atanmalıdır**.

-   `final` nesne referansı değiştirilemez ama nesnenin içi değiştirilebilir (örnek: `final List`).

* * * * *

5\. Örnek Program
-----------------

```java


`public class Test {
    public static final double PI = 3.14;
    public static int sayac = 0;

    public Test() {
        sayac++;
    }

    public static void yazdir() {
        System.out.println("Sayaç: " + sayac);
        // System.out.println(PI);  // Evet erişilebilir
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        Test t2 = new Test();

        Test.yazdir();   // Sayaç: 2

        // PI = 3.1415;  // Hata! final olduğu için değiştirilemez
    }
}`

```
# Overload ve Override Farkları

## 1. Overload (Metot Aşırı Yükleme)

- Aynı isimli metodu, **farklı parametre listeleri** ile tanımlamaktır.  
- **Compile-time (derleme zamanı) polimorfizmi** sağlar.  
- Dönüş tipi farklı olabilir ama tek başına dönüş tipi değiştirmek overload sayılmaz, **parametre farkı şarttır**.  
- Aynı sınıf içinde de yapılabilir, farklı sınıflarda da (inheritance gerekmez).  

---

## 2. Override (Metot Ezme)

- **Miras (inheritance)** ilişkisi gerekir.  
- Alt sınıf, üst sınıftaki metodu **aynı isim, aynı parametre listesi** ile yeniden tanımlar.  
- **Runtime (çalışma zamanı) polimorfizmi** sağlar.  
- Dönüş tipi aynı olmak zorunda (Java’da *covariant return type* yani daha özel bir tip dönebilir).  
- Genelde `@Override` annotation’ı kullanılır.  

---

## Compile-time Polymorphism (Derleme Zamanı)

- Program **derlenirken** hangi metodun çağrılacağı bellidir.  
- Karar mekanizması compile aşamasında çalışır.  
- **Overload** buna örnektir.  
- **Avantaj:** Hızlıdır, çünkü runtime’da ekstra karar verme yoktur.  

---

## Runtime Polymorphism (Çalışma Zamanı)

- Hangi metodun çalışacağına **program çalışırken** karar verilir.  
- **Kalıtım + override** sayesinde olur.  
- **Override** buna örnektir.  
- **Avantaj:** Esneklik sağlar.  
- **Dezavantaj:** Compile-time’a göre biraz daha yavaştır.  

---

## Özet

- **Overload** → Aynı sınıfta olur; metot ismi aynı ama parametre listesi farklıdır, **compile-time polimorfizmi** sağlar.  
- **Override** → Inheritance ile olur; metot imzası tamamen aynı kalır, alt sınıf üst sınıfın metodunu yeniden yazar ve **runtime polimorfizmi** sağlar.  
