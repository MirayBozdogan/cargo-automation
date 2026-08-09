# Müşteri Ekleme Endpoint'i İçin Best Practice Tavsiyeleri

## 1. Zorunlu alanları net tanımla
Bu yaklaşım kullan:
- `name`, `surname`, `email`, `age`, `tc`, `telNo` zorunlu olsun.
- boş ve whitespace değerleri kabul edilmesin.

## 2. Validasyon kurallarını netleştir
Önerilen kural seti:
- `name` ve `surname`: `@NotBlank`
- `email`: `@Email`
- `age`: `@NotNull` ve `@Min(18)`
- `tc`: `@NotBlank` ve `@Size(min=11, max=11)`
- `telNo`: `@NotBlank`, `@Pattern` ve uygun uzunluk kontrolü

## 3. Tip güvenliğini koru
Bu yaklaşım uygundur:
- `name` ve `surname` sadece string olmalı.
- `age` sadece sayı olmalı.
- sayı/boolean gibi yanlış tipler kabul edilmemeli.

## 4. Duplicate kontrolünü merkezileştir
Şu mantık daha iyi olur:
- email, TC ve telefon numarası kontrolü tek bir servis metodu içinde toplanmalı.
- böylece tekrar eden kontrol mantığı azalır.

## 5. Hata mesajlarını standartlaştır
Önerilen yapı:
- alan bazlı hata listesi
- ya da tek bir `message` alanı
- tüm hatalarda aynı format kullanılmalı

## 6. Exception handling ekle
Daha profesyonel yaklaşım:
- `MethodArgumentNotValidException`
- `IllegalArgumentException`
- `DuplicateResourceException`

gibi durumlar için özel handler eklenmeli.

## 7. Testleri başarı ve hata senaryolarıyla yaz
Bu senaryolar mutlaka test edilmeli:
- geçerli müşteri oluşturma
- eksik alanla istek
- invalid email
- küçük yaş
- kısa TC
- kısa telefon
- yanlış tipte veri
- duplicate email/TC/telefon

## 8. Veritabanı tarafında da koruma ekle
Bu yaklaşım iyi sonuç verir:
- email/TC/telefon için unique constraint eklenebilir.
- uygulama katmanında atlanan hatalar veritabanına düşmez.

## 9. Kısa öneri
Müşteri ekleme endpoint'i için başlangıç olarak şu adımlar uygun olur:
1. zorunlu alanları net tanımla
2. boş/null/whitespace değerlerini reddet
3. tip güvenliğini koru
4. duplicate kontrolünü merkezileştir
5. hata mesajlarını standartlaştır
6. testleri ekleyerek doğrula
