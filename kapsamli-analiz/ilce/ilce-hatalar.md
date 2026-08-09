# İlçe Ekleme Endpoint'i İçin Hata/Problem Notları

## Test edilen endpoint
- POST /district

## Test yöntemi
Aşağıdaki giriş türleri doğrudan endpoint'e gönderildi:
- geçerli değer
- boş obje
- eksik `name`
- eksik `cityId`
- `name: null`
- boş string
- sadece whitespace
- uzun string (256 karakter)
- çok uzun string (5000 karakter)
- sayı olarak `name`
- boolean olarak `name`
- dizi olarak `name`
- obje olarak `name`
- geçersiz `cityId`
- string `cityId`
- unicode karakterler
- JSON string'i
- bozuk JSON
- düz string body
- array body
- null body

## Test sonuçları

### 1) Geçerli veri
- Girdi: {"name":"Kadıköy","cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Beklenen davranış: kabul edilmelidir.

### 2) Boş obje gönderimi
- Girdi: {}
- Sonuç: 500 Internal Server Error
- Problem: `name` ve `cityId` eksik; bu durum sunucu hatasına dönüştü.

### 3) `name` alanı eksik
- Girdi: {"cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: `name` alanı yokken işlem başarılı kabul edildi.
- Bu, beklenmeyen bir davranıştır.

### 4) `cityId` alanı eksik
- Girdi: {"name":"Kadıköy"}
- Sonuç: 500 Internal Server Error
- Problem: şehir id olmadan işlem sunucu hatası verdi.

### 5) `name: null`
- Girdi: {"name":null,"cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: null değer kabul edildi.

### 6) Boş string
- Girdi: {"name":"","cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: boş değer kabul edildi.

### 7) Sadece whitespace
- Girdi: {"name":"   ","cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: sadece boşluklardan oluşan değer kabul edildi.

### 8) Uzun string (256 karakter)
- Girdi: 256 karakterlik `name`
- Sonuç: 500 Internal Server Error
- Problem: uzun değer sunucu hatası oluşturdu.

### 9) Çok uzun string (5000 karakter)
- Girdi: 5000 karakterlik `name`
- Sonuç: 500 Internal Server Error

### 10) Sayı olarak `name`
- Girdi: {"name":123,"cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: sayı string gibi kabul edildi.

### 11) Boolean olarak `name`
- Girdi: {"name":true,"cityId":<geçerli şehir id>}
- Sonuç: 200 OK
- Problem: boolean da kabul edildi.

### 12) Dizi olarak `name`
- Girdi: {"name":["Kadıköy"],"cityId":<geçerli şehir id>}
- Sonuç: 400 Bad Request

### 13) Obje olarak `name`
- Girdi: {"name":{"inner":"value"},"cityId":<geçerli şehir id>}
- Sonuç: 400 Bad Request

### 14) Geçersiz `cityId`
- Girdi: {"name":"Kadıköy","cityId":999999}
- Sonuç: 500 Internal Server Error
- Problem: geçersiz şehir id için sunucu hatası döndü.

### 15) String `cityId`
- Girdi: {"name":"Kadıköy","cityId":"abc"}
- Sonuç: 400 Bad Request

### 16) Unicode karakterler
- Girdi: {"name":"Şişli-Çekmeköy-İstanbul","cityId":<geçerli şehir id>}
- Sonuç: 200 OK

### 17) JSON string içeren değer
- Girdi: {"name":"{\"x\":1}","cityId":<geçerli şehir id>}
- Sonuç: 200 OK

### 18) Bozuk JSON body
- Girdi: {"name":"Kadıköy","cityId":
- Sonuç: 400 Bad Request

### 19) Düz string body
- Girdi: "Kadıköy"
- Sonuç: 400 Bad Request

### 20) Array body
- Girdi: ["Kadıköy","Şişli"]
- Sonuç: 400 Bad Request

### 21) Null body
- Girdi: null
- Sonuç: 400 Bad Request

## Ana bulgular
1. İlçe ekleme endpoint'i de zayıf doğrulama kullanıyor.
2. `name` alanı eksik veya boş olsa bile bazı durumlarda başarılı kabul ediliyor.
3. `cityId` eksikse ya da geçersizse sunucu hatası veriyor.
4. Uzun stringler 500 hatası oluşturuyor.
5. Sayı ve boolean gibi farklı tipler kabul ediliyor.
6. Hata mesajları standart değil.
