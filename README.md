📚 Kütüphane Yönetim Sistemi - REST API
Kütüphane Yönetim Sistemi projesinin Spring Boot ile geliştirilmiş REST API uygulaması.
Katmanlı mimari kullanılarak CRUD operasyonları, iş mantığı validasyonları ve DTO yapıları ile tasarlanmıştır.

🚀 Proje Özellikleri
Maven tabanlı Spring Boot projesi

Entity, Repository, Service ve Controller katmanları

İş mantığı servis katmanında, HTTP durum kodları controller’da

Validation anotasyonları ile veri doğrulama (Lombok destekli)

PostgreSQL veritabanı bağlantısı ve tablolar

DTO yapısı ile veri transferi (Request & Response)

Stok kontrolü ve kategori silme mantığı

Constructor Injection ile bağımlılık yönetimi

Yayınevi GET endpoint’lerinde adres bilgisi gizli

Kitap ödünç alma güncellemesinde e-mail girişi engellenmiş

📋 API Endpoints
Method	Endpoint	Açıklama	Status Kodları
GET	/api/authors	Yazarları listele	200 OK
POST	/api/authors	Yeni yazar ekle	201 Created
GET	/api/books	Kitapları listele	200 OK
POST	/api/books	Yeni kitap ekle	201 Created
GET	/api/categories	Kategorileri listele	200 OK
DELETE	/api/categories/{id}	Kategori sil (kitap bağlı ise engellenir)	200 OK / 400 Bad Request
POST	/api/bookborrowings	Kitap ödünç al (stok kontrolü yapılır)	201 Created / 400 Bad Request
PUT	/api/bookborrowings/{id}	Ödünç alma bilgisi güncelle	200 OK

⚙️ Teknolojiler
Java 17

Spring Boot 3.x

Spring Data JPA

PostgreSQL

Lombok

Hibernate Validator

📌 Kurulum & Çalıştırma
PostgreSQL veritabanı oluşturun ve bağlantı bilgilerini application.properties dosyasına girin.

Projeyi klonlayın ve Maven ile bağımlılıkları indirin:

bash
Kopyala
Düzenle
mvn clean install
Uygulamayı başlatın:

bash
Kopyala
Düzenle
mvn spring-boot:run
API’yi Postman gibi araçlarla test edin.

Projede emeği geçen: Gülşah BALLI GİRDAP
© 2025
