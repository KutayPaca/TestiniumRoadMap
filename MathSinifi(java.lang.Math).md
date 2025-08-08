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

Trig (radyan unutma!)
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
