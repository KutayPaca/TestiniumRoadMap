# Kullanılan Teknolojiler

---

## Apache Maven Nedir?

Maven, bir build tool (yapı aracı) ve aynı zamanda bir dependency manager (bağımlılık yöneticisi) olarak çalışır.

---

## Maven Nasıl Çalışır?

1. `pom.xml` dosyasını okur.  
2. Tanımlı bağımlılıkları Maven Central veya başka bir repository'den indirir.  
3. Projeyi derler, test eder ve paketler.

 **Lifecycle:** `compile` → `test` → `package` → `install` → `deploy`

---

## Kendi Yazdığın Bir Package Maven'de Nasıl Kullanılır?

1. Kendi projenin `pom.xml` dosyasını düzgün yapılandırırsın (groupId, artifactId, version verilir).  
2. Projeyi `.jar` olarak build edersin.  
3. Sonra ya:
   - `mvn install` komutuyla lokal .m2 repository'ye eklersin,  
   - ya da `mvn deploy` ile remote repository (Maven Central, Nexus, JFrog Artifactory vb.)'ye yüklersin.  
4. Başkası senin `groupId`, `artifactId`, `version` bilgilerini kullanarak kendi `pom.xml` dosyasına dependency olarak ekleyebilir.

---

## Özetle

- Maven, `pom.xml` dosyasındaki bağımlılıkları okuyup **Maven Central** gibi repository’lerden otomatik indirir.  
- Örneğin Spring kullanmak istiyorsam sadece dependency tanımı yazarım, Maven ilgili jar dosyasını otomatik bulup indirir.  
- Kendi yazdığım bir kütüphaneyi `mvn install` ile lokal Maven repo’ya ekleyip kendi projelerimde kullanabilirim.  
- Eğer başkaları da kullansın istersem, Maven Central veya özel bir repository’ye `mvn deploy` ile publish edebilirim.
