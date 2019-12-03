# BuildingInfo
5.11.19
dodaję edita
Błażej Granat i Dawid Jankowiak

Projekt IO
IO Project for study 2019
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.


DoD(obowiązkowe):
1.Kod jest pod kontrolą systemu zarządzania wersjami (Github) i prowadzący ma do niego dostęp	
2.Kod określający inkrement produktu jest oznaczony w repozytorium (tag = numer wersji) oraz odpowiednia wersja w pom.xml
3.Aplikacja buduje się w sposób automatyczny (kompilacja, stworzenie paczki do dystrybucji)	
4.Skonfigurowano środowisko ciągłej integracji i prowadzący ma do niego dostęp (serwer CI reaguje na zmiany w repozytorium kodu i uruchamia proces budowania)	
5.Dokumentacja generuje się w sposób automatyczny podczas budowy oprogramowania	
6.Przynajmniej 1 klasa / interfejs posiada pełną dokumentację techniczną* (javadoc, itp.)		
7.Skonfigurowano środowisko do zarządzania rejestrem produktu i rejestrem sprintu, prowadzący ma do niego dostęp (np. Github Issues, Github Projects, Trello)	
8.Podczas implementacji wykorzystano sugerowany wzorzec projektowy w proponowanym zakresie: TextTransformer - Dekorator wykorzystany do dynamicznego tworzenia obiektu transformującego; Scenario Quality Checker - Wizytator będzie użyty do analizy scenariuszy i pod-scenariuszy; Building Info - Kompozyt do reprezentacji struktury pomieszczeń oraz wywoływania operacji mających bezpośredni związek ze strukturą danych (obliczenia powierzchni, kubatury, zużycia energii, mocy oświetlenia). Wizytator do funkcji raportujących, Bootstrap Builder - budowniczy do podzielenia budowy strony na fragmenty (np. nagłówke, treść, stopka), JSON tools - wzorzec dekorator do dynamicznego tworzenia wyjścia na bazie poszczególnych opcji (np. filtrowanie, minifkacja)	

DoD(opcjonalne):
1.Przynajmniej 3 klasy / interfejsy posiadają pełną dokumentację techniczną* (javadoc, itp.)
2.Zaprojektowano model klas (dla wlasnych klas, jeśli więcej niż 10 to ograniczyć do najważniejszych klas) z wykorzystaniem diagramu klas UML i umieszczono go w repozytorium lub na wiki projektu.	
