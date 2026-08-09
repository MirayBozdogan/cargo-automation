# Şehir Ekleme Endpoint'i İçin Best Practice Tavsiyeleri

## 1. Önce doğrulama ekle
Bu yaklaşım kullan:
- `name` alanı zorunlu olsun.
- boş string kabul edilmesin.
- sadece whitespace içeren değerler kabul edilmesin.
- `@NotBlank` ve `@Size(max=100)` gibi kurallar kullanılsın.

## 2. Hata mesajlarını standartlaştır
Şu mantıkla ilerle:
- tüm hatalar tek bir yapı ile dönsün.
- örneğin `{ "message": "Geçersiz şehir adı" }` gibi bir format kullanılabilir.
- `400 Bad Request` yerine daha açıklayıcı hata yönetimi tercih edilebilir.

## 3. String sınırlarını belirle
Bu yöntem iyi çalışır:
- şehir adı için maksimum karakter sınırı belirlenmelidir.
- örneğin 100 karakter gibi bir limit konulabilir.
- böylece çok uzun değerler doğrudan kabul edilmez.

## 4. Tip güvenliğini koru
Bu yaklaşım kullan:
- `name` alanı sadece string olmalı.
- sayı, boolean, obje veya dizi gibi farklı tipler kabul edilmemeli.
- Spring validasyon ve DTO ile bu kontrol netleştirilebilir.

## 5. DTO kullanmaya devam et
Şu mantık doğru olur:
- controller seviyesinde doğrudan entity kullanmak yerine request DTO kullan.
- böylece API giriş formatı daha net ve kontrollü olur.

## 6. Exception handling ekle
Bu yaklaşım daha profesyoneldir:
- `MethodArgumentNotValidException`
- `IllegalArgumentException`
- `ConstraintViolationException`

gibi durumlar için özel hata dönüşümleri eklenmelidir.

## 7. Testleri sınır değerlerle yaz
Bu yöntemle ilerle:
- normal değer testi
- boş değer testi
- null testi
- whitespace testi
- çok uzun string testi
- sayı/boolean testi
- bozuk JSON testi

Bu testler hem unit hem integration seviyesinde yazılmalıdır.

## 8. Veritabanı tarafında da koruma ekle
Bu yaklaşım iyi sonuç verir:
- entity üzerinde `@Column(length = 100)` gibi kısıtlar koy.
- gerekirse DB seviyesinde de kontrol eklenebilir.
- böylece uygulama katmanında atlanan hatalar veritabanına ulaşmaz.

## 9. Araştırma odaklı ilerle
Şu mantıkla devam et:
- önce Spring Boot validation dokümantasyonunu incele
- sonra bu projeye uygun örneği uygula
- en sonunda test ederek doğrula

## 10. Kısa öneri
Şehir ekleme endpoint'i için en iyi başlangıç şu olur:
1. `name` alanını zorunlu yap
2. boş/null/whitespace değerleri reddet
3. maksimum uzunluk belirle
4. farklı tipleri reddet
5. hata mesajlarını standartlaştır
6. testleri ekleyerek doğrula
