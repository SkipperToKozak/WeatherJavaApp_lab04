# WeatherApp ☀️🌧️❄️

WeatherApp to aplikacja desktopowa napisana w Javie, która umożliwia przeglądanie aktualnych danych meteorologicznych dla wszystkich dostępnych stacji pogodowych w Polsce. Aplikacja prezentuje dane w formie przejrzystych tabel oraz wykresów, umożliwiając analizę temperatury, wiatru (wraz z jego kierunkiem), opadów i ciśnienia.

## Źródło danych

Dane pogodowe pochodzą z oficjalnego API Instytutu Meteorologii i Gospodarki Wodnej (IMGW):  
🔗 [https://danepubliczne.imgw.pl/pl/apiinfo](https://danepubliczne.imgw.pl/pl/apiinfo)

## Technologie

- Java 17+
- Java Swing (interfejs graficzny)
- [Gson](https://github.com/google/gson) – do parsowania danych JSON
- [JFreeChart](https://www.jfree.org/jfreechart/) – do tworzenia wykresów

## Funkcjonalności

- Lista wszystkich dostępnych stacji meteorologicznych w Polsce
- Aktualne dane dla:
  - Temperatury
  - Ciśnienia
  - Prędkości i kierunku wiatru
  - Opadów
- Wybór sposobu prezentacji danych: **tabela** lub **wykres**
- Graficzny interfejs użytkownika (Java Swing + JFreeChart)

## Uruchamianie

Pobierz najnowszą wersję aplikacji jako instalator (.exe) dla systemu Windows:  
[Pobierz instalator](https://github.com/SkipperToKozak/WeatherJavaApp_lab04/releases/latest)

Aplikacja zawiera wbudowane środowisko Java (JDK), więc **nie wymaga instalacji Javy** w systemie. Po prostu pobierz i uruchom.

## Zależności

Projekt korzysta z dwóch zewnętrznych bibliotek:
- `gson`
- `jfreechart`

Biblioteki zostały dołączone do finalnej wersji aplikacji w instalatorze.

## Licencja

Ten projekt jest dostępny na licencji MIT.  
Oznacza to, że możesz go swobodnie kopiować, modyfikować i używać, pod warunkiem zachowania informacji o autorze.

📌 **Uwaga**: Aplikacja wymaga dostępu do internetu, aby pobrać aktualne dane pogodowe z API IMGW.
