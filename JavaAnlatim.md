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




