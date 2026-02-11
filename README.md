# LAST FLIGHT

**Autor:** Marek Kulhánek

## ✒️ Popis hry
Hra LAST FLIGHT je textová adventura, kde se hráč ocitne na letišti,  
kde mu únosce sebere jeho syna a hráč tak  
musí zachránit svou rodinu do té doby, než mu uplyne čas.  
Čekají ho při tom různé nástrahy a úkoly. Hráč se také dostane  
k minihře kde si bude moci svůj čas vsadit.  

## 💻 Použitelné příkazy
* `jdi [místnost]` - To přesune hráče do místnosti kterou napíše.
* `prozkoumej` - Prozkoumá aktuální místnost.
* `vezmi [předmět]` - Přidá do batohu předmět.
* `pouzij [předmět]` - Použije předmět.
* `poloz [předmět]` - Položí předmět na zem.
* `inventar` - Otevře svůj batoh.
* `mluv [postava]` - Mluví s postavou.
* `dej [postava] [předmět]` - Dá předmět postavě.
* `utok` - Zaútočí na únosce.
* `uhni` - Vyhne se únosci.
* `pomoc` - Vypíše všechny příkazy co může použít.
* `napoveda [úroveň]` - Zobrazí stupňovanou nápovědu podle úrovně.
* `konec` - Ukončí okamžitě hru.

## 🎮 Herní mechaniky
* **Systém času** - Každá akce hráče ubírá čas více času ubírá akce  
když je hráč zraněný nebo bloudí.
* **Souboj** - Při souboji musí hráč adekvátně zareagovat na akci únosce,  
která se každé kolo souboje mění jinak dostane penalizaci.
* **Stav postav** - Každá postava má svoji povahu a ta se může změnit tím jak  
  s ní hráč interaguje a to může ovlivnit to jestli mu postava pomůže nebo ne.
* **MiniHra** - Hráč při hraní narazí i na grafickou hru skořápek ve které  
si hráč může svůj čas vsadit.

## ✅ Jak hru spustit
1. Stáhněte si soubor LASTFLIGHT.jar.
2. Spusťte soubor v terminálu.

## 📚 Použité knihovny
* GSON - pro načtení dat do hry z JSON souboru.
* Swing - pro Jframe na minihru.