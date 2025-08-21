# Drone Module

Bu proje, **Drone yönetim sistemi** için bir örnek uygulamadır.  
Projede **Factory Pattern** ve **Strategy Pattern** temel prensiplerine göre yapılandırılmıştır. Ayrıca, dronların aktif/pasif durumları enum ile kontrol edilmekte ve uçuş yönetimi `DroneRequest` sınıfı üzerinden sağlanmaktadır.

---

## 📂 Dosya Yapısı
```
src/
└── drone/
├── strategy/ # FlyStrategy interface ve implementasyonları
│ ├── FlyStrategy.java
│ ├── DirectFlyStrategy.java
│ ├── ObstacleAvoidanceStrategy.java
│ └── ExplorationStrategy.java
│
├── model/ # Drone ve DroneType enum
│ ├── Drone.java
│ └── DroneType.java
│
├── factory/ # Drone üretim sınıfı
│ └── DroneFactory.java
│
├── request/ # Drone + Strategy uçuş yönetimi
│ └── DroneRequest.java
│
└── Main.java # Uygulamanın giriş noktası
```

---

## Kullanılan Patternler

### Factory Pattern
- `DroneFactory` sınıfı ile yeni dronlar üretilir.
- Yeni Drone tipleri eklemek kolaydır.

### Strategy Pattern
- `FlyStrategy` interface’i ile farklı uçuş stratejileri tanımlanır.
- `DirectFlyStrategy`, `ObstacleAvoidanceStrategy`, `ExplorationStrategy` implementasyonları mevcuttur.
- Strateji `DroneRequest` üzerinden dronlara atanır ve uçuş sırasında değiştirilebilir.

---

## Özellikler
- Dronlar `DroneType` enum ile tipleri ve aktif/pasif durumlarıyla yönetilir.
- Pasif dronlar uçuş yapamaz, terminalde bilgilendirme mesajı gösterilir.
- DroneRequest sınıfı dron + strategy ilişkisini yönetir.
- Dosya yapısı OOP ve clean code prensiplerine uygundur.

---

