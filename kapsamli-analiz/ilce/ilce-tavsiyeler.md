# İlçe Ekleme Endpoint'i İçin Best Practice Tavsiyeleri

## 1. Zorunlu alanları net tanımla
Bu yaklaşım kullan:
- `name` alanı zorunlu olsun.
- `cityId` alanı zorunlu olsun.
- boş string, whitespace ve null kabul edilmesin.

## 2. DTO ile giriş yapısını tanımla
Bu mantık daha temiz olur:
- request DTO kullan.
- `name` alanı `String` olarak tanımlansın.
- `cityId` alanı `Integer` olarak tanımlansın.

## 3. Validasyon ekle
Önerilen kurallar:
- `@NotBlank` for `name`
- `@NotNull` for `cityId`
- `@Size(max = 100)` for `name`

## 4. Tip güvenliğini koru
Bu yaklaşım uygundur:
- `name` alanı sadece string olmalı.
- `cityId` alanı sadece sayı olmalı.
- boolean, dizi, obje gibi değerler reddedilmeli.

## 5. Hata mesajlarını standartlaştır
Şu yapıyı tercih et:
- tek bir hata formatı kullan.
- örneğin `{ "message": "Geçersiz ilçe adı" }`
- ya da alan bazlı hata listelemesi yap.

## 6. Exception handling ekle
Daha profesyonel yaklaşım:
- `MethodArgumentNotValidException`
- `IllegalArgumentException`
- `EntityNotFoundException`

gibi durumlar için ayrı handler ekle.

## 7. Sunucu hatalarını önle
Şu adımlar faydalı olur:
- geçersiz `cityId` için 404 veya 400 dön.
- uzun stringler için 400 dön.
- `orElseThrow()` ile net hata yönetimi yap.

## 8. Testleri sınır değerlerle yaz
Şu senaryoları mutlaka test et:
- normal değer
- boş değer
- null
- whitespace
- çok uzun string
- geçersiz `cityId`
- sayı/boolean gibi yanlış tipler
- bozuk JSON body

## 9. Veritabanı tarafında da koruma ekle
Bu yaklaşım iyi sonuç verir:
- `@Column(length = 100)` gibi kısıtlar koy.
- gerekli ise DB seviyesinde de kontrol ekle.

## 10. Kısa öneri
İlçe ekleme endpoint'i için başlangıç olarak şu adımlar uygun olur:
1. `name` ve `cityId` zorunlu yap
2. boş/null/whitespace değerleri reddet
3. maksimum uzunluk belirle
4. yanlış tipleri reddet
5. hata mesajlarını standartlaştır
6. testleri ekleyerek doğrula
