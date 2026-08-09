# Şehir Ekleme Endpoint'i İçin Hata/Problem Notları

## Test edilen endpoint
- POST /city

## Test yöntemi
Aşağıdaki giriş türleri doğrudan endpoint'e gönderildi:
- geçerli değer
- boş obje
- eksik alan
- null değeri
- boş string
- sadece whitespace
- uzun string (256 karakter)
- çok uzun string (5000 karakter)
- sayı
- boolean
- dizi
- obje
- JSON string'i
- unicode karakterler
- bozuk JSON
- düz string body
- array body
- null body

## Test sonuçları

### 1) Geçerli veri
- Girdi: {"name":"İstanbul"}
- Sonuç: 200 OK
- Beklenen davranış: kabul edilmelidir.

### 2) Boş obje gönderimi
- Girdi: {}
- Sonuç: 200 OK
- Problem: `name` alanı eksik olsa bile işlem başarılı kabul edildi.
- Bu, beklenmeyen bir davranıştır.

### 3) `name` alanı eksik
- Girdi: {"foo":"bar"}
- Sonuç: 200 OK
- Problem: alan adı kontrolü yok.

### 4) `name: null`
- Girdi: {"name":null}
- Sonuç: 200 OK
- Problem: null değer kabul edilip kaydedildi.

### 5) Boş string
- Girdi: {"name":""}
- Sonuç: 200 OK
- Problem: boş değer kabul ediliyor.

### 6) Sadece whitespace
- Girdi: {"name":"   "}
- Sonuç: 200 OK
- Problem: sadece boşluklardan oluşan değer de kabul ediliyor.

### 7) Uzun string (256 karakter)
- Girdi: 256 karakterlik string
- Sonuç: 500 Internal Server Error
- Problem: sunucu hatası oluştu.
- Muhtemel neden: veritabanı kolonunun karakter sınırına takılması.

### 8) Çok uzun string (5000 karakter)
- Girdi: 5000 karakterlik string
- Sonuç: 500 Internal Server Error
- Problem: aynı şekilde sunucu hatası verdi.

### 9) Sayı gönderimi
- Girdi: {"name":123}
- Sonuç: 200 OK
- Problem: sayı string'e dönüştürülerek kaydedildi.
- Bu, tip güvenliğini zayıflatır.

### 10) Boolean gönderimi
- Girdi: {"name":true}
- Sonuç: 200 OK
- Problem: boolean da string gibi işlenmiş görünüyor.

### 11) Dizi gönderimi
- Girdi: {"name":["İstanbul"]}
- Sonuç: 400 Bad Request
- Problem: beklenen tip dışında veri gönderildi.

### 12) Obje gönderimi
- Girdi: {"name":{"inner":"value"}}
- Sonuç: 400 Bad Request
- Problem: aynı şekilde geçersiz tip olarak reddedildi.

### 13) JSON string içeren değer
- Girdi: {"name":"{\"x\":1}"}
- Sonuç: 200 OK
- Problem: string olarak kabul edilip kaydedildi.

### 14) Unicode karakterler
- Girdi: {"name":"İzmir-Şehir-Çok-Ünlü-Ж"}
- Sonuç: 200 OK
- Problem: bu durumda sorun yok; ancak kuralların net olması gerekir.

### 15) Bozuk JSON body
- Girdi: {"name": "Ankara"
- Sonuç: 400 Bad Request
- Problem: JSON parse hatası olarak reddedildi.

### 16) Düz string body
- Girdi: "İstanbul"
- Sonuç: 400 Bad Request
- Problem: beklenen JSON yapısı değil.

### 17) Array body
- Girdi: ["İstanbul","Ankara"]
- Sonuç: 400 Bad Request

### 18) Null body
- Girdi: null
- Sonuç: 400 Bad Request

## Ana bulgular
1. Endpoint çok zayıf doğrulama yapıyor.
2. `null`, boş string ve whitespace değerleri kabul ediliyor.
3. Uzun metinler sunucu hatası oluşturuyor.
4. Sayı ve boolean gibi farklı tipler string'e çevrilerek kabul ediliyor.
5. Hata cevapları standart değil.
6. API'nin beklenen input formatı net değil.

## Kısa değerlendirme
Şehir ekleme endpoint'i şu an "her şeyi kabul eder gibi" bir davranış sergiliyor. Bu da veri kalitesini düşürür ve ileride veri bütünlüğü sorunlarına yol açabilir.
