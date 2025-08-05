# RoadMap Bilgileri

Aşağıdaki araçlar başarıyla kuruldu:

- Java Temurin 21.0.8  
- Apache Maven 3.9.11  
- Docker 28.3.2  
- IntelliJ IDEA  
- Git 2.45.1  

Kurulum tamamlandı ve 2 alıştırma sorusu çözüldü.

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

## 7. Kısa Özet

| Yapı           | Özellik                                      | Kullanım Alanı                                                          |
| -------------- | -------------------------------------------- | ----------------------------------------------------------------------- |
| **Array**      | Sabit uzunluklu, hızlı erişim                | Sabit boyutlu veri tutmak için                                          |
| **ArrayList**  | Dinamik, hızlı erişim, sıralı, tekrar eleman | Tek iş parçacıklı veya thread-safe olmayan durumlar için                |
| **LinkedList** | Dinamik, hızlı ekleme/silme, yavaş erişim    | Çok ekleme/silme olan durumlar                                          |
| **Vector**     | Dinamik, synchronized (thread-safe)          | Çoklu thread ortamlarında, ancak günümüzde alternatifleri tercih edilir |

---

