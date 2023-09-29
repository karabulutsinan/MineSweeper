
# MineSweeper

Oyunun amacı bir alanda mayınlara rastlamadan tüm boş kareleri bulmaktır. Karelere tıklayınca çıkan sayılar ise karenin etrafındaki mayın sayısının toplamını gösterir.


## İçerikler

- Oyun metin tabanlıdır.
- Matris boyutunu (satır ve sütun sayısını) kullanıcı belirlemektedir.
- Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmektedir. Örneğin matris 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile hesaplanmakta ve boyutu 12 olmaktadır. Bu durumda mayın sayısı 12 / 4 = 3 adet olarak belirlenmektedir.
- Kullanıcı matris üzerinden bir nokta seçmekte olup, seçtiği noktayı için satır ve sütun değerleri olarak girmektedir.
- Seçilen noktanın dizinin sınırları içerisinde olup olmadığı kontrol edilip, koşul sağlanmaması durumunda tekrar nokta istenmektedir.
- Kullanıcı, seçtiği koordinatta mayın olması durumunda oyunu kaybetmektedir.
- Oyunun sonlanması durumunda çözüm haritası kullanıcıya gösterilerek kendisine kazanma/kaybetme durumu uygun mesaj ile terminale yazdırılmaktadır.


  