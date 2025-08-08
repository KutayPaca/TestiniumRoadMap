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
