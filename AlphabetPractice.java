import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AlphabetPractice extends JFrame {

    int vocabSize = 200;
    int count = 0;
    int correct = 0;
    int incorrect = 0;
    int fontSize = 20;
    private JFrame frameMain;
    private JPanel highlight;
    private JLabel instructionText;
    private JPanel scoreHighlight;
    private JLabel score;
    private JTextField input;
    private JButton enter;
    private JButton reset;
    private JLabel feedback;
    private JLabel pronunciation;
    private JButton moveOn;

    /* NOTE: for the cyrilic and english arrays to match up, the cyrilic
        word MUST MATCH UP with the INDEX of the english meaning in the
        English word array  */ 
    String[][] pronunciationMeaning = new String[3][vocabSize];

    String cyrilicWord;

    public AlphabetPractice() {
        
        // if statement to help shrink long input of cyrilic vocab
        // Categories covered: fruits, vegetables, animals, countries, common
        // words/phrases, household objects
        if (true) {
            pronunciationMeaning[0][0] = "яблоко";
            pronunciationMeaning[1][0] = "yabloko";
            pronunciationMeaning[2][0] = "apple";
            pronunciationMeaning[0][1] = "банан";
            pronunciationMeaning[1][1] = "banana";
            pronunciationMeaning[2][1] = "banana";
            pronunciationMeaning[0][2] = "груша";
            pronunciationMeaning[1][2] = "grusha";
            pronunciationMeaning[2][2] = "pear";
            pronunciationMeaning[0][3] = "апельсин";
            pronunciationMeaning[1][3] = "apelsin";
            pronunciationMeaning[2][3] = "orange";
            pronunciationMeaning[0][4] = "лимон";
            pronunciationMeaning[1][4] = "limon";
            pronunciationMeaning[2][4] = "lemon";
            pronunciationMeaning[0][5] = "арбуз";
            pronunciationMeaning[1][5] = "arbuz";
            pronunciationMeaning[2][5] = "watermelon";
            pronunciationMeaning[0][6] = "вишня";
            pronunciationMeaning[1][6] = "vishnya";
            pronunciationMeaning[2][6] = "cherry";
            pronunciationMeaning[0][7] = "клубника";
            pronunciationMeaning[1][7] = "klubnika";
            pronunciationMeaning[2][7] = "strawberry";
            pronunciationMeaning[0][8] = "помидор";
            pronunciationMeaning[1][8] = "pomidor";
            pronunciationMeaning[2][8] = "tomato";
            pronunciationMeaning[0][9] = "огурец";
            pronunciationMeaning[1][9] = "ogurets";
            pronunciationMeaning[2][9] = "cucumber";
            pronunciationMeaning[0][10] = "морковь";
            pronunciationMeaning[1][10] = "morkov";
            pronunciationMeaning[2][10] = "carrot";
            pronunciationMeaning[0][11] = "брокколи";
            pronunciationMeaning[1][11] = "brokkoli";
            pronunciationMeaning[2][11] = "broccoli";
            pronunciationMeaning[0][12] = "капуста";
            pronunciationMeaning[1][12] = "kapusta";
            pronunciationMeaning[2][12] = "cabbage";
            pronunciationMeaning[0][13] = "картофель";
            pronunciationMeaning[1][13] = "kartofel";
            pronunciationMeaning[2][13] = "potato";
            pronunciationMeaning[0][14] = "лук";
            pronunciationMeaning[1][14] = "luk";
            pronunciationMeaning[2][14] = "onion";
            pronunciationMeaning[0][15] = "чеснок";
            pronunciationMeaning[1][15] = "chesnok";
            pronunciationMeaning[2][15] = "garlic";
            pronunciationMeaning[0][16] = "манго";
            pronunciationMeaning[1][16] = "mango";
            pronunciationMeaning[2][16] = "mango";
            pronunciationMeaning[0][17] = "ананас";
            pronunciationMeaning[1][17] = "ananas";
            pronunciationMeaning[2][17] = "pineapple";
            pronunciationMeaning[0][18] = "киви";
            pronunciationMeaning[1][18] = "kiwi";
            pronunciationMeaning[2][18] = "kiwi";
            pronunciationMeaning[0][19] = "грейпфрут";
            pronunciationMeaning[1][19] = "greypfrut";
            pronunciationMeaning[2][19] = "grapefruit";
            pronunciationMeaning[0][20] = "малина";
            pronunciationMeaning[1][20] = "malina";
            pronunciationMeaning[2][20] = "raspberry";
            pronunciationMeaning[0][21] = "ежевика";
            pronunciationMeaning[1][21] = "ejevika";
            pronunciationMeaning[2][21] = "blackberry";
            pronunciationMeaning[0][22] = "арбуз";
            pronunciationMeaning[1][22] = "arbuz";
            pronunciationMeaning[2][22] = "watermelon";
            pronunciationMeaning[0][23] = "гранат";
            pronunciationMeaning[1][23] = "granat";
            pronunciationMeaning[2][23] = "pomegranate";
            pronunciationMeaning[0][24] = "апельсин";
            pronunciationMeaning[1][24] = "apelsin";
            pronunciationMeaning[2][24] = "orange";
            pronunciationMeaning[0][25] = "лимон";
            pronunciationMeaning[1][25] = "limon";
            pronunciationMeaning[2][25] = "lemon";
            pronunciationMeaning[0][26] = "груша";
            pronunciationMeaning[1][26] = "grusha";
            pronunciationMeaning[2][26] = "pear";
            pronunciationMeaning[0][27] = "черешня";
            pronunciationMeaning[1][27] = "chereshnya";
            pronunciationMeaning[2][27] = "cherry";
            pronunciationMeaning[0][28] = "клубника";
            pronunciationMeaning[1][28] = "klubnika";
            pronunciationMeaning[2][28] = "strawberry";
            pronunciationMeaning[0][29] = "ежевика";
            pronunciationMeaning[1][29] = "ejevika";
            pronunciationMeaning[2][29] = "blackberry";
            pronunciationMeaning[0][30] = "свекла";
            pronunciationMeaning[1][30] = "svekla";
            pronunciationMeaning[2][30] = "beetroot";
            pronunciationMeaning[0][31] = "шпинат";
            pronunciationMeaning[1][31] = "shpinat";
            pronunciationMeaning[2][31] = "spinach";
            pronunciationMeaning[0][32] = "брюква";
            pronunciationMeaning[1][32] = "bryukva";
            pronunciationMeaning[2][32] = "rutabaga";
            pronunciationMeaning[0][33] = "редис";
            pronunciationMeaning[1][33] = "redis";
            pronunciationMeaning[2][33] = "radish";
            pronunciationMeaning[0][34] = "фасоль";
            pronunciationMeaning[1][34] = "fasol";
            pronunciationMeaning[2][34] = "beans";
            pronunciationMeaning[0][35] = "огурец";
            pronunciationMeaning[1][35] = "ogurets";
            pronunciationMeaning[2][35] = "cucumber";
            pronunciationMeaning[0][36] = "кабачок";
            pronunciationMeaning[1][36] = "kabachok";
            pronunciationMeaning[2][36] = "zucchini";
            pronunciationMeaning[0][37] = "капуста";
            pronunciationMeaning[1][37] = "kapusta";
            pronunciationMeaning[2][37] = "cabbage";
            pronunciationMeaning[0][38] = "морковь";
            pronunciationMeaning[1][38] = "morkov";
            pronunciationMeaning[2][38] = "carrot";
            pronunciationMeaning[0][39] = "брокколи";
            pronunciationMeaning[1][39] = "brokkoli";
            pronunciationMeaning[2][39] = "broccoli";
            pronunciationMeaning[0][40] = "лук";
            pronunciationMeaning[1][40] = "luk";
            pronunciationMeaning[2][40] = "onion";
            pronunciationMeaning[0][41] = "чеснок";
            pronunciationMeaning[1][41] = "chesnok";
            pronunciationMeaning[2][41] = "garlic";
            pronunciationMeaning[0][42] = "кресс-салат";
            pronunciationMeaning[1][42] = "kress-salat";
            pronunciationMeaning[2][42] = "watercress";
            pronunciationMeaning[0][43] = "сельдерей";
            pronunciationMeaning[1][43] = "selderey";
            pronunciationMeaning[2][43] = "celery";
            pronunciationMeaning[0][44] = "петрушка";
            pronunciationMeaning[1][44] = "petrushka";
            pronunciationMeaning[2][44] = "parsley";
            pronunciationMeaning[0][45] = "репа";
            pronunciationMeaning[1][45] = "repa";
            pronunciationMeaning[2][45] = "turnip";
            pronunciationMeaning[0][46] = "тыква";
            pronunciationMeaning[1][46] = "tykva";
            pronunciationMeaning[2][46] = "pumpkin";
            pronunciationMeaning[0][47] = "перец";
            pronunciationMeaning[1][47] = "perec";
            pronunciationMeaning[2][47] = "pepper";
            pronunciationMeaning[0][48] = "помидор";
            pronunciationMeaning[1][48] = "pomidor";
            pronunciationMeaning[2][48] = "tomato";
            pronunciationMeaning[0][49] = "баклажан";
            pronunciationMeaning[1][49] = "baklazhan";
            pronunciationMeaning[2][49] = "eggplant";
            pronunciationMeaning[0][50] = "кошка";
            pronunciationMeaning[1][50] = "koshka";
            pronunciationMeaning[2][50] = "cat";
            pronunciationMeaning[0][51] = "собака";
            pronunciationMeaning[1][51] = "sobaka";
            pronunciationMeaning[2][51] = "dog";
            pronunciationMeaning[0][52] = "корова";
            pronunciationMeaning[1][52] = "korova";
            pronunciationMeaning[2][52] = "cow";
            pronunciationMeaning[0][53] = "свинья";
            pronunciationMeaning[1][53] = "svinya";
            pronunciationMeaning[2][53] = "pig";
            pronunciationMeaning[0][54] = "лошадь";
            pronunciationMeaning[1][54] = "loshad";
            pronunciationMeaning[2][54] = "horse";
            pronunciationMeaning[0][55] = "овца";
            pronunciationMeaning[1][55] = "ovtsa";
            pronunciationMeaning[2][55] = "sheep";
            pronunciationMeaning[0][56] = "коза";
            pronunciationMeaning[1][56] = "koza";
            pronunciationMeaning[2][56] = "goat";
            pronunciationMeaning[0][57] = "курица";
            pronunciationMeaning[1][57] = "kuritsa";
            pronunciationMeaning[2][57] = "chicken";
            pronunciationMeaning[0][58] = "утка";
            pronunciationMeaning[1][58] = "utka";
            pronunciationMeaning[2][58] = "duck";
            pronunciationMeaning[0][59] = "кролик";
            pronunciationMeaning[1][59] = "krolik";
            pronunciationMeaning[2][59] = "rabbit";
            pronunciationMeaning[0][60] = "петух";
            pronunciationMeaning[1][60] = "petuh";
            pronunciationMeaning[2][60] = "rooster";
            pronunciationMeaning[0][61] = "коршун";
            pronunciationMeaning[1][61] = "korshun";
            pronunciationMeaning[2][61] = "hawk";
            pronunciationMeaning[0][62] = "волк";
            pronunciationMeaning[1][62] = "volk";
            pronunciationMeaning[2][62] = "wolf";
            pronunciationMeaning[0][63] = "лисица";
            pronunciationMeaning[1][63] = "lisitsa";
            pronunciationMeaning[2][63] = "fox";
            pronunciationMeaning[0][64] = "медведь";
            pronunciationMeaning[1][64] = "medved";
            pronunciationMeaning[2][64] = "bear";
            pronunciationMeaning[0][65] = "тигр";
            pronunciationMeaning[1][65] = "tigr";
            pronunciationMeaning[2][65] = "tiger";
            pronunciationMeaning[0][66] = "лев";
            pronunciationMeaning[1][66] = "lev";
            pronunciationMeaning[2][66] = "lion";
            pronunciationMeaning[0][67] = "змея";
            pronunciationMeaning[1][67] = "zmeya";
            pronunciationMeaning[2][67] = "snake";
            pronunciationMeaning[0][68] = "крокодил";
            pronunciationMeaning[1][68] = "krokodil";
            pronunciationMeaning[2][68] = "crocodile";
            pronunciationMeaning[0][69] = "жираф";
            pronunciationMeaning[1][69] = "zhiraf";
            pronunciationMeaning[2][69] = "giraffe";
            pronunciationMeaning[0][70] = "слон";
            pronunciationMeaning[1][70] = "slon";
            pronunciationMeaning[2][70] = "elephant";
            pronunciationMeaning[0][71] = "жаба";
            pronunciationMeaning[1][71] = "zhaba";
            pronunciationMeaning[2][71] = "frog";
            pronunciationMeaning[0][72] = "рыба";
            pronunciationMeaning[1][72] = "ryba";
            pronunciationMeaning[2][72] = "fish";
            pronunciationMeaning[0][73] = "птица";
            pronunciationMeaning[1][73] = "ptitsa";
            pronunciationMeaning[2][73] = "bird";
            pronunciationMeaning[0][74] = "пингвин";
            pronunciationMeaning[1][74] = "pingvin";
            pronunciationMeaning[2][74] = "penguin";
            pronunciationMeaning[0][75] = "морская свинка";
            pronunciationMeaning[1][75] = "morskaya svinka";
            pronunciationMeaning[2][75] = "guinea pig";
            pronunciationMeaning[0][76] = "еж";
            pronunciationMeaning[1][76] = "ezh";
            pronunciationMeaning[2][76] = "hedgehog";
            pronunciationMeaning[0][77] = "муравей";
            pronunciationMeaning[1][77] = "muravey";
            pronunciationMeaning[2][77] = "ant";
            pronunciationMeaning[0][78] = "пчела";
            pronunciationMeaning[1][78] = "pchela";
            pronunciationMeaning[2][78] = "bee";
            pronunciationMeaning[0][79] = "паук";
            pronunciationMeaning[1][79] = "pauk";
            pronunciationMeaning[2][79] = "spider";
            pronunciationMeaning[0][80] = "жук";
            pronunciationMeaning[1][80] = "zhuk";
            pronunciationMeaning[2][80] = "beetle";
            pronunciationMeaning[0][81] = "Россия";
            pronunciationMeaning[1][81] = "Rossiya";
            pronunciationMeaning[2][81] = "Russia";
            pronunciationMeaning[0][82] = "США";
            pronunciationMeaning[1][82] = "SShA";
            pronunciationMeaning[2][82] = "USA";
            pronunciationMeaning[0][83] = "Китай";
            pronunciationMeaning[1][83] = "Kitay";
            pronunciationMeaning[2][83] = "China";
            pronunciationMeaning[0][84] = "Германия";
            pronunciationMeaning[1][84] = "Germaniya";
            pronunciationMeaning[2][84] = "Germany";
            pronunciationMeaning[0][85] = "Франция";
            pronunciationMeaning[1][85] = "Frantsiya";
            pronunciationMeaning[2][85] = "France";
            pronunciationMeaning[0][86] = "Италия";
            pronunciationMeaning[1][86] = "Italiya";
            pronunciationMeaning[2][86] = "Italy";
            pronunciationMeaning[0][87] = "Япония";
            pronunciationMeaning[1][87] = "Yaponiya";
            pronunciationMeaning[2][87] = "Japan";
            pronunciationMeaning[0][88] = "Великобритания";
            pronunciationMeaning[1][88] = "Velikobritaniya";
            pronunciationMeaning[2][88] = "United Kingdom";
            pronunciationMeaning[0][89] = "Индия";
            pronunciationMeaning[1][89] = "Indiya";
            pronunciationMeaning[2][89] = "India";
            pronunciationMeaning[0][90] = "Бразилия";
            pronunciationMeaning[1][90] = "Braziliya";
            pronunciationMeaning[2][90] = "Brazil";
            pronunciationMeaning[0][91] = "Канада";
            pronunciationMeaning[1][91] = "Kanada";
            pronunciationMeaning[2][91] = "Canada";
            pronunciationMeaning[0][92] = "Австралия";
            pronunciationMeaning[1][92] = "Avstraliya";
            pronunciationMeaning[2][92] = "Australia";
            pronunciationMeaning[0][93] = "Испания";
            pronunciationMeaning[1][93] = "Ispaniya";
            pronunciationMeaning[2][93] = "Spain";
            pronunciationMeaning[0][94] = "Мексика";
            pronunciationMeaning[1][94] = "Meksika";
            pronunciationMeaning[2][94] = "Mexico";
            pronunciationMeaning[0][95] = "Южная Корея";
            pronunciationMeaning[1][95] = "Yuzhnaya Koreya";
            pronunciationMeaning[2][95] = "South Korea";
            pronunciationMeaning[0][96] = "Греция";
            pronunciationMeaning[1][96] = "Gretsiya";
            pronunciationMeaning[2][96] = "Greece";
            pronunciationMeaning[0][97] = "Швеция";
            pronunciationMeaning[1][97] = "Shvetsiya";
            pronunciationMeaning[2][97] = "Sweden";
            pronunciationMeaning[0][98] = "Саудовская Аравия";
            pronunciationMeaning[1][98] = "Saudovskaya Araviya";
            pronunciationMeaning[2][98] = "Saudi Arabia";
            pronunciationMeaning[0][99] = "Турция";
            pronunciationMeaning[1][99] = "Turtsiya";
            pronunciationMeaning[2][99] = "Turkey";
            pronunciationMeaning[0][100] = "Норвегия";
            pronunciationMeaning[1][100] = "Norgegiya";
            pronunciationMeaning[2][100] = "Norway";
            pronunciationMeaning[0][101] = "Аргентина";
            pronunciationMeaning[1][101] = "Argentina";
            pronunciationMeaning[2][101] = "Argentina";
            pronunciationMeaning[0][102] = "Швейцария";
            pronunciationMeaning[1][102] = "Shveytsariya";
            pronunciationMeaning[2][102] = "Switzerland";
            pronunciationMeaning[0][103] = "Египет";
            pronunciationMeaning[1][103] = "Egipet";
            pronunciationMeaning[2][103] = "Egypt";
            pronunciationMeaning[0][104] = "Иран";
            pronunciationMeaning[1][104] = "Iran";
            pronunciationMeaning[2][104] = "Iran";
            pronunciationMeaning[0][105] = "Индонезия";
            pronunciationMeaning[1][105] = "Indoneziya";
            pronunciationMeaning[2][105] = "Indonesia";
            pronunciationMeaning[0][106] = "Польша";
            pronunciationMeaning[1][106] = "Polsha";
            pronunciationMeaning[2][106] = "Poland";
            pronunciationMeaning[0][107] = "Нидерланды";
            pronunciationMeaning[1][107] = "Niderlandy";
            pronunciationMeaning[2][107] = "Netherlands";
            pronunciationMeaning[0][108] = "Бельгия";
            pronunciationMeaning[1][108] = "Belgiya";
            pronunciationMeaning[2][108] = "Belgium";
            pronunciationMeaning[0][109] = "ЮАР";
            pronunciationMeaning[1][109] = "YuAR";
            pronunciationMeaning[2][109] = "South Africa";
            pronunciationMeaning[0][110] = "Марокко";
            pronunciationMeaning[1][110] = "Marokko";
            pronunciationMeaning[2][110] = "Morocco";
            pronunciationMeaning[0][111] = "Колумбия";
            pronunciationMeaning[1][111] = "Kolumbiya";
            pronunciationMeaning[2][111] = "Colombia";
            pronunciationMeaning[0][112] = "Куба";
            pronunciationMeaning[1][112] = "Kuba";
            pronunciationMeaning[2][112] = "Cuba";
            pronunciationMeaning[0][113] = "Новая Зеландия";
            pronunciationMeaning[1][113] = "Novaya Zelandiya";
            pronunciationMeaning[2][113] = "New Zealand";
            pronunciationMeaning[0][114] = "Австрия";
            pronunciationMeaning[1][114] = "Avstriya";
            pronunciationMeaning[2][114] = "Austria";
            pronunciationMeaning[0][115] = "Венгрия";
            pronunciationMeaning[1][115] = "Vengriya";
            pronunciationMeaning[2][115] = "Hungary";
            pronunciationMeaning[0][116] = "Украина";
            pronunciationMeaning[1][116] = "Ukraina";
            pronunciationMeaning[2][116] = "Ukraine";
            pronunciationMeaning[0][117] = "Португалия";
            pronunciationMeaning[1][117] = "Portugaliya";
            pronunciationMeaning[2][117] = "Portugal";
            pronunciationMeaning[0][118] = "Чехия";
            pronunciationMeaning[1][118] = "Chehiya";
            pronunciationMeaning[2][118] = "Czech Republic";
            pronunciationMeaning[0][119] = "Сербия";
            pronunciationMeaning[1][119] = "Serbiya";
            pronunciationMeaning[2][119] = "Serbia";
            pronunciationMeaning[0][120] = "привет";
            pronunciationMeaning[1][120] = "privet";
            pronunciationMeaning[2][120] = "hello";
            pronunciationMeaning[0][121] = "спасибо";
            pronunciationMeaning[1][121] = "spasibo";
            pronunciationMeaning[2][121] = "thank you";
            pronunciationMeaning[0][122] = "извините";
            pronunciationMeaning[1][122] = "izvinite";
            pronunciationMeaning[2][122] = "excuse me";
            pronunciationMeaning[0][123] = "пожалуйста";
            pronunciationMeaning[1][123] = "pozhaluysta";
            pronunciationMeaning[2][123] = "you're welcome";
            pronunciationMeaning[0][124] = "как дела?";
            pronunciationMeaning[1][124] = "kak dela?";
            pronunciationMeaning[2][124] = "how are you?";
            pronunciationMeaning[0][125] = "хорошо";
            pronunciationMeaning[1][125] = "horosho";
            pronunciationMeaning[2][125] = "good";
            pronunciationMeaning[0][126] = "плохо";
            pronunciationMeaning[1][126] = "plokho";
            pronunciationMeaning[2][126] = "bad";
            pronunciationMeaning[0][127] = "извини";
            pronunciationMeaning[1][127] = "izvini";
            pronunciationMeaning[2][127] = "sorry";
            pronunciationMeaning[0][128] = "пока";
            pronunciationMeaning[1][128] = "poka";
            pronunciationMeaning[2][128] = "bye";
            pronunciationMeaning[0][129] = "спокойной ночи";
            pronunciationMeaning[1][129] = "spokoynoy nochi";
            pronunciationMeaning[2][129] = "good night";
            pronunciationMeaning[0][130] = "до свидания";
            pronunciationMeaning[1][130] = "do svidaniya";
            pronunciationMeaning[2][130] = "goodbye";
            pronunciationMeaning[0][131] = "конечно";
            pronunciationMeaning[1][131] = "konechno";
            pronunciationMeaning[2][131] = "of course";
            pronunciationMeaning[0][132] = "нет";
            pronunciationMeaning[1][132] = "net";
            pronunciationMeaning[2][132] = "no";
            pronunciationMeaning[0][133] = "да";
            pronunciationMeaning[1][133] = "da";
            pronunciationMeaning[2][133] = "yes";
            pronunciationMeaning[0][134] = "очень хорошо";
            pronunciationMeaning[1][134] = "ochen' khorosho";
            pronunciationMeaning[2][134] = "very good";
            pronunciationMeaning[0][135] = "не понимаю";
            pronunciationMeaning[1][135] = "ne ponimayu";
            pronunciationMeaning[2][135] = "I don't understand";
            pronunciationMeaning[0][136] = "сколько стоит?";
            pronunciationMeaning[1][136] = "skol'ko stoit?";
            pronunciationMeaning[2][136] = "how much does it cost?";
            pronunciationMeaning[0][137] = "простите";
            pronunciationMeaning[1][137] = "prostite";
            pronunciationMeaning[2][137] = "sorry";
            pronunciationMeaning[0][138] = "надеюсь";
            pronunciationMeaning[1][138] = "nadeyus'";
            pronunciationMeaning[2][138] = "I hope";
            pronunciationMeaning[0][139] = "возможно";
            pronunciationMeaning[1][139] = "vozmozhno";
            pronunciationMeaning[2][139] = "maybe";
            pronunciationMeaning[0][140] = "интересно";
            pronunciationMeaning[1][140] = "interesno";
            pronunciationMeaning[2][140] = "interesting";
            pronunciationMeaning[0][141] = "помогите";
            pronunciationMeaning[1][141] = "pomogite";
            pronunciationMeaning[2][141] = "help me";
            pronunciationMeaning[0][142] = "хочу";
            pronunciationMeaning[1][142] = "khochu";
            pronunciationMeaning[2][142] = "I want";
            pronunciationMeaning[0][143] = "здесь";
            pronunciationMeaning[1][143] = "zdes'";
            pronunciationMeaning[2][143] = "here";
            pronunciationMeaning[0][144] = "там";
            pronunciationMeaning[1][144] = "tam";
            pronunciationMeaning[2][144] = "there";
            pronunciationMeaning[0][145] = "больше";
            pronunciationMeaning[1][145] = "bol'she";
            pronunciationMeaning[2][145] = "more";
            pronunciationMeaning[0][146] = "меньше";
            pronunciationMeaning[1][146] = "men'she";
            pronunciationMeaning[2][146] = "less";
            pronunciationMeaning[0][147] = "сейчас";
            pronunciationMeaning[1][147] = "seychas";
            pronunciationMeaning[2][147] = "now";
            pronunciationMeaning[0][148] = "вчера";
            pronunciationMeaning[1][148] = "vchera";
            pronunciationMeaning[2][148] = "yesterday";
            pronunciationMeaning[0][149] = "сегодня";
            pronunciationMeaning[1][149] = "segodnya";
            pronunciationMeaning[2][149] = "today";
            pronunciationMeaning[0][150] = "стол";
            pronunciationMeaning[1][150] = "stol";
            pronunciationMeaning[2][150] = "table";
            pronunciationMeaning[0][151] = "стул";
            pronunciationMeaning[1][151] = "stul";
            pronunciationMeaning[2][151] = "chair";
            pronunciationMeaning[0][152] = "кровать";
            pronunciationMeaning[1][152] = "krovat'";
            pronunciationMeaning[2][152] = "bed";
            pronunciationMeaning[0][153] = "шкаф";
            pronunciationMeaning[1][153] = "shkaf";
            pronunciationMeaning[2][153] = "cabinet";
            pronunciationMeaning[0][154] = "диван";
            pronunciationMeaning[1][154] = "divan";
            pronunciationMeaning[2][154] = "sofa";
            pronunciationMeaning[0][155] = "столешница";
            pronunciationMeaning[1][155] = "stoleshnitsa";
            pronunciationMeaning[2][155] = "countertop";
            pronunciationMeaning[0][156] = "полка";
            pronunciationMeaning[1][156] = "polka";
            pronunciationMeaning[2][156] = "shelf";
            pronunciationMeaning[0][157] = "лампа";
            pronunciationMeaning[1][157] = "lampa";
            pronunciationMeaning[2][157] = "lamp";
            pronunciationMeaning[0][158] = "ковер";
            pronunciationMeaning[1][158] = "kover";
            pronunciationMeaning[2][158] = "rug";
            pronunciationMeaning[0][159] = "подушка";
            pronunciationMeaning[1][159] = "podushka";
            pronunciationMeaning[2][159] = "pillow";
            pronunciationMeaning[0][160] = "постельное белье";
            pronunciationMeaning[1][160] = "postel'noye bel'ye";
            pronunciationMeaning[2][160] = "bedding";
            pronunciationMeaning[0][161] = "полотенце";
            pronunciationMeaning[1][161] = "polotentse";
            pronunciationMeaning[2][161] = "towel";
            pronunciationMeaning[0][162] = "тарелка";
            pronunciationMeaning[1][162] = "tarelka";
            pronunciationMeaning[2][162] = "plate";
            pronunciationMeaning[0][163] = "чашка";
            pronunciationMeaning[1][163] = "chashka";
            pronunciationMeaning[2][163] = "cup";
            pronunciationMeaning[0][164] = "ложка";
            pronunciationMeaning[1][164] = "lozhka";
            pronunciationMeaning[2][164] = "spoon";
            pronunciationMeaning[0][165] = "вилка";
            pronunciationMeaning[1][165] = "vilka";
            pronunciationMeaning[2][165] = "fork";
            pronunciationMeaning[0][166] = "нож";
            pronunciationMeaning[1][166] = "nozh";
            pronunciationMeaning[2][166] = "knife";
            pronunciationMeaning[0][167] = "таз";
            pronunciationMeaning[1][167] = "taz";
            pronunciationMeaning[2][167] = "basin";
            pronunciationMeaning[0][168] = "ведро";
            pronunciationMeaning[1][168] = "vedro";
            pronunciationMeaning[2][168] = "bucket";
            pronunciationMeaning[0][169] = "мыло";
            pronunciationMeaning[1][169] = "mylo";
            pronunciationMeaning[2][169] = "soap";
            pronunciationMeaning[0][170] = "щетка";
            pronunciationMeaning[1][170] = "shchetka";
            pronunciationMeaning[2][170] = "brush";
            pronunciationMeaning[0][171] = "пылесос";
            pronunciationMeaning[1][171] = "pylesos";
            pronunciationMeaning[2][171] = "vacuum cleaner";
            pronunciationMeaning[0][172] = "утюг";
            pronunciationMeaning[1][172] = "utyug";
            pronunciationMeaning[2][172] = "iron";
            pronunciationMeaning[0][173] = "плита";
            pronunciationMeaning[1][173] = "plita";
            pronunciationMeaning[2][173] = "stove";
            pronunciationMeaning[0][174] = "холодильник";
            pronunciationMeaning[1][174] = "kholodil'nik";
            pronunciationMeaning[2][174] = "refrigerator";
            pronunciationMeaning[0][175] = "микроволновка";
            pronunciationMeaning[1][175] = "mikrovolnovka";
            pronunciationMeaning[2][175] = "microwave";
            pronunciationMeaning[0][176] = "кофеварка";
            pronunciationMeaning[1][176] = "kofevarka";
            pronunciationMeaning[2][176] = "coffee maker";
            pronunciationMeaning[0][177] = "чайник";
            pronunciationMeaning[1][177] = "chaynik";
            pronunciationMeaning[2][177] = "kettle";
            pronunciationMeaning[0][178] = "телевизор";
            pronunciationMeaning[1][178] = "televizor";
            pronunciationMeaning[2][178] = "television";
            pronunciationMeaning[0][179] = "радио";
            pronunciationMeaning[1][179] = "radio";
            pronunciationMeaning[2][179] = "radio";
            pronunciationMeaning[0][180] = "компьютер";
            pronunciationMeaning[1][180] = "kompyuter";
            pronunciationMeaning[2][180] = "computer";
            pronunciationMeaning[0][181] = "принтер";
            pronunciationMeaning[1][181] = "printer";
            pronunciationMeaning[2][181] = "printer";
            pronunciationMeaning[0][182] = "сканер";
            pronunciationMeaning[1][182] = "skaner";
            pronunciationMeaning[2][182] = "scanner";
            pronunciationMeaning[0][183] = "лампочка";
            pronunciationMeaning[1][183] = "lampochka";
            pronunciationMeaning[2][183] = "lightbulb";
            pronunciationMeaning[0][184] = "батарейка";
            pronunciationMeaning[1][184] = "batareyka";
            pronunciationMeaning[2][184] = "battery";
            pronunciationMeaning[0][185] = "розетка";
            pronunciationMeaning[1][185] = "rozetka";
            pronunciationMeaning[2][185] = "outlet";
            pronunciationMeaning[0][186] = "вилка";
            pronunciationMeaning[1][186] = "vilka";
            pronunciationMeaning[2][186] = "plug";
            pronunciationMeaning[0][187] = "шнур";
            pronunciationMeaning[1][187] = "shnur";
            pronunciationMeaning[2][187] = "cord";
            pronunciationMeaning[0][188] = "ванна";
            pronunciationMeaning[1][188] = "vanna";
            pronunciationMeaning[2][188] = "bathtub";
            pronunciationMeaning[0][189] = "душ";
            pronunciationMeaning[1][189] = "dush";
            pronunciationMeaning[2][189] = "shower";
            pronunciationMeaning[0][190] = "унитаз";
            pronunciationMeaning[1][190] = "unitaz";
            pronunciationMeaning[2][190] = "toilet";
            pronunciationMeaning[0][191] = "раковина";
            pronunciationMeaning[1][191] = "rakovina";
            pronunciationMeaning[2][191] = "sink";
            pronunciationMeaning[0][192] = "зеркало";
            pronunciationMeaning[1][192] = "zerkalo";
            pronunciationMeaning[2][192] = "mirror";
            pronunciationMeaning[0][193] = "полотенцедержатель";
            pronunciationMeaning[1][193] = "polotentsederzhatel'";
            pronunciationMeaning[2][193] = "towel holder";
            pronunciationMeaning[0][194] = "дверь";
            pronunciationMeaning[1][194] = "dver'";
            pronunciationMeaning[2][194] = "door";
            pronunciationMeaning[0][195] = "окно";
            pronunciationMeaning[1][195] = "okno";
            pronunciationMeaning[2][195] = "window";
            pronunciationMeaning[0][196] = "гардеробная";
            pronunciationMeaning[1][196] = "garderobnaya";
            pronunciationMeaning[2][196] = "closet";
            pronunciationMeaning[0][197] = "пол";
            pronunciationMeaning[1][197] = "pol";
            pronunciationMeaning[2][197] = "floor";
            pronunciationMeaning[0][198] = "потолок";
            pronunciationMeaning[1][198] = "potolok";
            pronunciationMeaning[2][198] = "ceiling";
            pronunciationMeaning[0][199] = "стена";
            pronunciationMeaning[1][199] = "stena";
            pronunciationMeaning[2][199] = "wall";
        }
            
        int frameWidth = 800;
        int frameHeight = 600;
        frameMain = new JFrame();
        frameMain.setTitle("Cyrilic Alphabet Tutor");
        frameMain.setSize(frameWidth, frameHeight);
        frameMain.setVisible(true);
        frameMain.setLayout(null);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMain.setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();

        ImageIcon backgroundImageIcon = new ImageIcon
            ("NearAChurch_FyodorVasilev.jfif");
        JLabel background = new JLabel(backgroundImageIcon);
        background.setBounds(0, 0, frameWidth, frameHeight);
        layeredPane.add(background, JLayeredPane.FRAME_CONTENT_LAYER);


        //String to be displayed in instructions
        cyrilicWord = randomize();

        // Instruction text, contains cyrilic word
        instructionText = new JLabel ("<html>" + "Type the English pronunciation of [ " 
            + cyrilicWord + " ]. Click Enter when you are finished." + "</html>");
        instructionText.setBounds(frameWidth/25, 0, 
            frameWidth-frameWidth/5, frameHeight/2);
        instructionText.setFont(new Font("Courier", Font.BOLD, fontSize));

        // box behind instructions to make it stand out
        highlight = new JPanel();
        highlight.setBounds(frameWidth/50, frameHeight/5, 
            frameWidth-frameWidth/10, frameHeight/9);
        highlight.setBackground(Color.WHITE);
        
        // score measuring correct and incorrect counts
        score = new JLabel ("<html>" + "Correct: " + correct + 
            " Incorrect: " + incorrect + "</html>");
        score.setFont(new Font("Courier", Font.BOLD, fontSize));
        score.setBounds(frameWidth/25, 0, 
            frameWidth-frameWidth/5, frameHeight/10);
        
        scoreHighlight = new JPanel();
        scoreHighlight.setBounds(frameWidth/50, frameHeight/100, 
            (int) (frameWidth-frameWidth/1.8), frameHeight/11);
        scoreHighlight.setBackground(Color.WHITE);

        // Text box to type answers in
        input = new JTextField();
        input.setBounds(frameWidth/50, (int) (frameHeight/2.5), 
            (int) (frameWidth * 0.7), frameHeight/6);
        input.setFont(new Font("Courier", Font.BOLD, fontSize));
        
        // Setting up interactible "enter" button
        enter = new JButton("Enter");
        enter.setFont(new Font("Courier", Font.BOLD, fontSize));
        enter.setBounds((int) (frameWidth * 0.78), (int) (frameHeight/2.5), 
            frameWidth/8, frameHeight/6);
        enter.setBackground(Color.WHITE);
        enter.setOpaque(true);
        frameMain.getRootPane().setDefaultButton(enter);

        reset = new JButton("Reset");
        reset.setFont(new Font("Courier", Font.BOLD, fontSize));
        reset.setBounds(frameWidth/50, (int) (frameHeight/1.5), 
            frameWidth/8, frameHeight/6);
        reset.setBackground(Color.WHITE);
        reset.setOpaque(true);

        layeredPane.add(highlight,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(scoreHighlight,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(score, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(instructionText, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(input, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(reset, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(enter, JLayeredPane.PALETTE_LAYER);
        frameMain.setContentPane(layeredPane);
        frameMain.setVisible(true);
        /* 
        frameMain.add(instructionText);
        frameMain.add(input);
        frameMain.add(enter);
        */

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent a) {
                enter.setEnabled(false);
        
                // Popup window after enter is clicked
                JFrame popup = new JFrame();
                int popupWidth = 500;
                int popupHeight = 400;
                popup.setTitle("Feedback");
                popup.setSize(popupWidth, popupHeight);
                popup.setLayout(null);
                popup.setVisible(true);
        
                feedback = new JLabel();
                feedback.setBounds(popupWidth/100, popupHeight/100, 
                    popupWidth, popupHeight/2);
                feedback.setFont(new Font("Courier", Font.BOLD, 20));
                
                pronunciation = new JLabel();
                pronunciation.setBounds(popupWidth/100, popupHeight/100 + popupHeight/5
                    , popupWidth, popupHeight/2);
                pronunciation.setText
                    ("<html>" + analyzeCyrillicString(pronunciationMeaning[0][count])
                    + "</html>");
                pronunciation.setFont(new Font("Courier", Font.BOLD, 20));
                
                String userResponse = input.getText();
                if (userResponse.equalsIgnoreCase(pronunciationMeaning[1][count])) {
                    feedback.setText("<html>" + "Correct! " + 
                     pronunciationMeaning[0][count] + " is pronounced as " + 
                     pronunciationMeaning[1][count] + ". It means " +
                     pronunciationMeaning[2][count] + "." + 
                     "\n Press the Enter key to move on. "
                     + "</html>");
                     correct++;
                }   else {
                    feedback.setText("<html>" + "Not quite. " + 
                     pronunciationMeaning[0][count] + " is pronounced as " + 
                     pronunciationMeaning[1][count] + ". It means " +
                     pronunciationMeaning[2][count] + "." + 
                     "\n Press the Enter key to move on. "
                     + "</html>");
                    incorrect++;
                }   
                moveOn = new JButton();
                moveOn.setBounds(0, 0, popupWidth, popupHeight);
                moveOn.setBackground(Color.WHITE);
                moveOn.setOpaque(false);

                popup.add(feedback);
                popup.add(pronunciation);
                popup.add(moveOn);

                popup.getRootPane().setDefaultButton(moveOn);
                moveOn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed (ActionEvent e) {
                        enter.setEnabled(true);
                        popup.dispose();
                    }
                });
        
                String newWord = randomize();
                instructionText.setText("<html>" + "Type the English pronunciation of [ "
                     + newWord + " ]. Click Enter when you are finished." + 
                     "</html>");
                input.setText("");
                score.setText("<html>" + "Correct: " + correct + 
                " Incorrect: " + incorrect + "</html>");
            }
        }
        ); 
        
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                correct = 0;
                incorrect = 0;
                score.setText("<html>" + "Correct: " + correct + 
                " Incorrect: " + incorrect + "</html>");
            }
        });
    }

    public String randomize() {
        String returnString = "";
        int rng = (int) (Math.random() * vocabSize);
        count = rng;
        returnString = pronunciationMeaning[0][rng];
        return returnString;
    }

    public String analyzeCyrillicString(String cyrillicString) {
        String pronunciation = new String();
        
        for (int i = 0; i < cyrillicString.length(); i++) {
            char c = cyrillicString.charAt(i);
            
            // Check if the character is Cyrillic
            if (Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC) {
                // Map the Cyrillic character to its English pronunciation
                String englishPronunciation = 
                    mapCyrillicToEnglishPronunciation(c);
                
                // Append the character and its pronunciation to the result
                pronunciation += c + "- " + englishPronunciation + "; ";
            }
        }
        
        return pronunciation;
    }

    private String mapCyrillicToEnglishPronunciation(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'а':
                return "a";
            case 'б':
                return "b";
            case 'в':
                return "v";
            case 'г':
                return "g";
            case 'д':
                return "d";
            case 'е':
                return "e";
            case 'ё':
                return "yo";
            case 'ж':
                return "zh";
            case 'з':
                return "z";
            case 'и':
                return "i";
            case 'й':
                return "y";
            case 'к':
                return "k";
            case 'л':
                return "l";
            case 'м':
                return "m";
            case 'н':
                return "n";
            case 'о':
                return "o";
            case 'п':
                return "p";
            case 'р':
                return "r";
            case 'с':
                return "s";
            case 'т':
                return "t";
            case 'у':
                return "u";
            case 'ф':
                return "f";
            case 'х':
                return "kh";
            case 'ц':
                return "ts";
            case 'ч':
                return "ch";
            case 'ш':
                return "sh";
            case 'щ':
                return "shch";
            case 'ъ':
                return "";
            case 'ы':
                return "y";
            case 'ь':
                return "'";
            case 'э':
                return "e";
            case 'ю':
                return "yu";
            case 'я':
                return "ya";
            default:
                return "Unknown";
        }
    }

    class BackgroundPanel extends JPanel {
        private Image backgroundImage;
    
        public BackgroundPanel(Image backgroundImage) {
            this.backgroundImage = backgroundImage;
        }
    
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main (String[] args) {
        AlphabetPractice app = new AlphabetPractice();
        app.setVisible(true);
    }
}