## Proje Yapısı

Package adı: `rpg`

src  
└── main  
└── java  
└── rpg  
├── Character.java   *// Interface (Parent)*  
├── Warrior.java     *// Alt sınıf*  
├── Mage.java        *// Alt sınıf*  
├── Archer.java      *// Alt sınıf*  
├── Sample.java      *// Tek methodlu class*  
└── Main.java        *// Test class*


---

## Sınıfların Açıklamaları

### 1. Character.java
Bu interface olarak tasarlandı. attack() methodu, tüm alt sınıfların uygulaması gereken ortak davranışı temsil ediyor.

### 2. Warrior.java, Mage.java, Archer.java
Bu sınıflar Character interface'ini implement ediyor.  
Her sınıf kendi attack() implementasyonunu yazıyor:
- Warrior → "Warrior slashes with a sword!"
- Mage → "Mage casts a fireball!"
- Archer → "Archer shoots an arrow!"

### 3. Sample.java
Tek method içeriyor.  
Method parametre olarak herhangi bir alt sınıfı kabul edebiliyor (Character character).  
Method içinde character.attack() çağrısı yapılıyor ve hangi alt sınıf gelirse gelsin kendi implementasyonu çalışıyor → polimorfizm örneği.

### 4. Main.java
Programın çalıştırıldığı ana sınıf.  
Sample class'ının tek methodu kullanılarak tüm karakterlerin saldırıları konsola yazdırılıyor.

---

## Öğrenilen Kavramlar
1. Interface ve Polimorfizm
    - Parent tipi (Character) üzerinden alt sınıfların kendi davranışlarını çağırabilme.
    - Tek method ile farklı davranışlar çalıştırılabiliyor.
2. Kalıtım
    - Warrior, Mage ve Archer interface'i implement ederek kalıtım alıyor.
3. Esnek ve ölçeklenebilir kod
    - Yeni bir karakter eklemek istediğinde sadece alt sınıfı yazmak yeterli, Sample class'a dokunmana gerek yok.
4. Proje yapısı ve temiz kod
    - Her sınıf ayrı dosya, package kullanımı.
    - Kod okunabilir ve mantığı takip etmek kolay.

---


