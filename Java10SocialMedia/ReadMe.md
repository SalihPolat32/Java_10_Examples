## Controller --> Spring MVC için geliştirilmiş bir anotasyondur.

Bunun REST mimari için geliştirilmiş hali @RestController anotasyonudur.

## Javada StereoType anotasyonları denilen anotasyonlar vardır. (@Component, @Service, @Repository, @Controller)

## @Component anotasyonu ile bir sınıfı Spring Container'a bean olarak tanımlayabiliriz.

## @Component --> @Service, @Repository, @Controller

@SpringBootApplication anotasyonu paketleri kontrol eder ve Stereotype anotasyonları bulunan sınıfları arka arkaya
hazırlar.
Bu sınıflardan bir Spring Bean nesnesi üretir. bean(adı = authService) --> (AuthService authService = new
AuthManager();) gibi
Bu ürettiği nesne sinleton yapıdadır. Singleton yapı --> bir kere üret (nesne), devamlı kullan
Nesne yönelimli programlamada IoC(Inversion of Control) --> Nesnelerin hayat döngüsünü kontrol etme denilen bir prensip
vardır.
IoC --> Bağımlılıkların yönetilmesi prensibidir, bunu yaparken de Dependency Injection(DI) prensibini kullanımını
tavsiye eder.
Dependency Injection(DI) --> Bağımlılıkların enjekte edilmesi prensibidir.
IoC Container --> Nesnelerin hayat döngüsünü yöneten ve DI prensibini kullanan araçtır. Singleton nesnelerin depolandığı
alandır.

AuthService authService = new AuthService(); (singleton)
UserService userService = new UserService(); (singleton)

AuthService authService = new AuthManager(); --> Bu kod ile nesne üretmek yerine IoC Container'a nesne üretme görevini
veririz.
IoC Container nesneyi üretir ve bizim kullanmamız için bize verir.
@Autowired anotasyonu ile Spring Bean nesnelerini birbirine bağlayabiliriz.
@Autowired anotasyonu ile bağlanacak nesne tipi ile bağlanacak nesnenin tipi aynı olmalıdır.

ApplicationContext = Spring Bean Container = Spring App Context = IoC Container
Üretilen beanler Spring tarafından application context'te tutulur ve injection yapılacağı zaman buradan çağrılır ve
kullanılır.
Spring tarafından StereoType anotasyonları sayesinde oluşturulan bean'ler sınıf düzeyinde bean'lerdir.
** Spring injection işlemi yapıldığında application context içerisinde önceden bean ismine bakarken artık oluşturulan
bean'in "sınıf tipine" bakarak injection işlemini gerçekleştirir.

## @Autowired nedir? Injection nedir? Aralarındaki fark nedir?

Autowired --> çalışma zamanında çalışırken, Injection --> derleme zamanında çalışır.

- Autowired, metot her tetiklendiğinde metot iççerisinde kullanılan bir injection nesnesi varsa gidip application
  context'ten
  bean'i anlık olarak çeker ve initialize eder.
- Injection ise program çalışırken application context'te gidip bean alıp initialize eder. Ve program çalıştığında bütün
  injection'lar bean'ler ile çalışabilir halde olur.
- Autowired önerilmez. Temel sebebi de aralarındaki performans farkından dolayıdır. Birisi(Injection) bütün işlemleri
  yapıp
  sistemi kullanıma hazır hale getirirken, birisi(Autowired) her seferinde application context'e gidip ek bi işlem
  yapmaktadır.

## Register işlemi için bir token üretiniz ve bu token ile kullanıcının durumunu ACTIVE yapınız.

Daha sonra login olarak login token elde ediniz.
Opsiyonel olarak --> register'da üretilen token'in önüne register Token: aıwhflahlfasfalk, login'de üretilene
login Token: laskfhaowjfa formatında bir çıktı da verebilirsiniz.

## Araştırma Konuları

    JDK vs JRE nedir?
    JVM nedir? Java JVM ile nasıl çalışır?
    Spring Stereo Type Annotation nedir? Anotasyonlar arasındaki farklar nelerdir?
    @Configuration ve @Bean nedir?
    @Configuration vs @Component
    ApplicationContext=SpringContainer nedir?
    Spring de bean mantığı nedir? (Spring bean)
    DI nedir? ne için kullanılır? tipleri nelerdir?
    Autowired nedir? Neden cons inj. neden autowired?
    SpringFramework vs SpringBoot?
    SOLID prensipleri nelerdir?
    RestAPI nedir? RESTful arch nedir?