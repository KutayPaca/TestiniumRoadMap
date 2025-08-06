# Kullanılan Teknolojiler

## Apache Maven nedir ?

Maven bir Build tool + Dependecy manager'dır.

---
## Maven nasıl çalışır?
1.Maven pom.xml dosyasını okur.
2.Tanımlı bağımlılıkları Maven Central'dan veya başka bir repository'den indirir.
3.Projeyi derler, test eder ve paketler.
lifecycle: compile-test-package-install-deploy şeklindedir.
---

---
## Kendi yazdığın bir package nasıl Maven'de kullanılabilir?

1.Kendi projemin pom.xml dosyasını düzgün yapılandırırım. (groupId, artifactId, version verilir).
2.Bu projeyi .jar olarak build ederim.
3.Ya:
Lokal .m2 repository’e mvn install komutuyla eklersin,
Ya da bir remote repository (Maven Central, Nexus, JFrog Artifactory) gibi bir yere mvn deploy ile yüklerim.
4.Artık başkası benim verdiğim groupId, artifactId, version bilgisiyle kendi pom.xml dosyasına beni ekleyip kullanabilir.
---

## Özetle
Maven, pom.xml dosyasındaki bağımlılıkları okuyup Maven Central gibi repository’lerden otomatik indirir.
Mesela Spring eklemek istiyorsam sadece dependency tanımı yazarım, Maven benim yerime jar dosyasını bulup indirir.
Kendi yazdığım bir kütüphaneyi mvn install ile lokal Maven repo’ya ekleyip kendi projelerimde dependency olarak kullanabiliyorum.
Eğer başkaları da kullansın istersem, Maven Central veya şirketin özel repository’sine mvn deploy ile publish edebilirim.

