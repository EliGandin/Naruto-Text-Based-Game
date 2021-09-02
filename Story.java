//Imports
import java.util.Scanner;
import java.util.Random;

class Story{
    
    public static void combat(Character hero, Character enemy){
        boolean myTurn = true;
        boolean running = true;
        int turnCounter = 0;
        int tempCounter = 0;
        int options = 4;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        while (running){
            if (myTurn == true){
                if (turnCounter >= 3)
                    hero.setInspect(true);
                System.out.println("You're stats are: " + '\n'+ "HP: " + hero.getHP() + '\n' + "Chakra: " + hero.getChakra() + '\n' + '\n' +
                "Please Select an Action:" + '\n' + 
                "1. Physical Attack" + '\n' +
                "2. Use Jutsu" + '\n' +
                "3. Use Ninja Tools" + '\n' + 
                "4. Inspect Enemy");
                int i = scan.nextInt();
                switch(i){
                    case 1: hero.phAttack(enemy);
                            System.out.println("You attacked using Taijutsu");
                            break;
                    case 2: System.out.println("Select a Jutsu from the list: ");
                            hero.printJutsuList();
                            i = scan.nextInt() - 1;
                            hero.useJutsu(enemy,i);
                            break;
                    case 3: System.out.println("Select a Jutsu from the list: ");
                            hero.printNInjaTool();
                            i = scan.nextInt();
                            hero.useNinjaTool(enemy, i - 1);
                            break;
                    case 4: hero.inspect(enemy);
                            break;
                }
                myTurn = false;
                System.out.println("___________________________________________________________________________________________________");
                if (enemy.isOut() == true){
                    running = false;
                    System.out.println('\n');
                }
                else{
                    if (enemy.getName().equals("Hidan")){
                        enemy.phAttack(hero);
                        System.out.println(enemy.getName() + " attacked using Taijutsu");
                        System.out.println("-- That did " + enemy.getPhSTR() + " point of damage, My HP is "+ hero.getHP() + '\n');
                    }
                    else{
                        i = rand.nextInt(3);
                    switch(i){
                        case 1: enemy.phAttack(hero);
                            System.out.println(enemy.getName() + " attacked using Taijutsu");
                                System.out.println("-- That did " + enemy.getPhSTR() + " point of damage, My HP is "+ hero.getHP() + '\n');
                                break;
                        case 2: i = rand.nextInt(options) + 1;
                                enemy.useJutsu(hero, i);
                                System.out.println(enemy.getName() + " attacked using " + enemy._jutsuList[i].getName());
                                System.out.println("-- That did " + enemy._jutsuList[i-1].getDamage() + " point of damage, My HP is "+ hero.getHP() + '\n');
                                break;
                        case 3: enemy.phAttack(hero);
                                System.out.println("-- That did " + enemy.getPhSTR() + " point of damage, My HP is "+ hero.getHP() + '\n');
                                break;
                        case 4: i = rand.nextInt(options) + 1;
                                enemy.useJutsu(hero, i);
                                System.out.println(enemy.getName() + " attacked using " + enemy._jutsuList[i].getName());
                                System.out.println("-- That did " + enemy._jutsuList[i-1].getDamage() + " point of damage, My HP is "+ hero.getHP() + '\n');
                                break;
                    } 
                }
                    if (hero.isOut() == true){
                        if (hero.getName().equals("Asuma Sarutobi"))
                            break;
                        else{
                        System.out.println("-- You've been defeated " + enemy.getName() + " --" + '\n');
                        running = false;
                        }
                    }
                    else{
                        myTurn = true;
                    }
                    turnCounter++;
                    System.out.println("___________________________________________________________________________________________________");
                    System.out.println('\n');
                }
            } 
        }
    }

public static void main(String[] args){
        // Naruto setup
        Jutsu shadowCloneNaruto = new Jutsu("Ninjutsu", "Shadow Clone Jutsu", "null", 15, "short+", 25);
        Jutsu rasengan = new Jutsu("NinJutsu", "Rasengan", "null", 25, "short", 55);
        NinjaTool kunaiNaruto = new NinjaTool("physical", "Kunai", "medium", 10 ,3);
        NinjaTool shurikenNaruto = new NinjaTool("physical", "Shuriken", "medium", 10 ,3);
        Character naruto = new Character("Naruto Uzumaki", "Village Hidden In The Leaves", Integer.MAX_VALUE, 200, 3, 6, 2);

        naruto.addJutsu(shadowCloneNaruto);
        naruto.addJutsu(rasengan);
        naruto.addNinjaTool(kunaiNaruto);
        naruto.addNinjaTool(shurikenNaruto);

        // Kakashi setup
        Jutsu lightningBlade = new Jutsu("Ninjutsu", "Lightning Blade", "Lightning Style", 25, "short", 55);
        Jutsu manHunter = new Jutsu("Ninjutsu", "Man Hunter Jutsu", "Earth Style", 15, "short", 0);
        Jutsu shadowCloneKakashi = new Jutsu("Ninjutsu", "Shadow Clone Jutsu", "null", 15, "short+", 25);
        NinjaTool kunaiKakashi = new NinjaTool("physical", "Kunai", "medium", 10 ,3);
        NinjaTool shurikenKakashi = new NinjaTool("physical", "Kunai", "medium", 10 ,3);
        Character kakashi = new Character("Kakashi Hatake", "Village Hidden In The Leaves", 250, 75, 3, 5, 3);

        kakashi.addJutsu(lightningBlade);
        kakashi.addJutsu(manHunter);
        kakashi.addJutsu(shadowCloneKakashi);
        kakashi.addNinjaTool(kunaiKakashi);
        kakashi.addNinjaTool(shurikenKakashi);

        // Asuma Sarutobi
        Jutsu ashpile = new Jutsu("Ninjutsu", "Ash Pile", "Fire Style", 35, "medium", 50);
        Jutsu flyingSwallow = new Jutsu("Bukijutsu", "Flying Swallow", "null", 35, "short", 25);
        Jutsu thousandHandStrike = new Jutsu("Ninjutsu", "Thousand Hand Strike", "null", 50, "short", 40);
        NinjaTool kunaiAsuma = new NinjaTool("physical", "Kunai", "medium", 10 ,3);
        NinjaTool shurikenAsuma = new NinjaTool("physical", "Kunai", "medium", 10 ,3);
        Character asuma = new Character("Asuma Sarutobi", "Village Hidden In The Leaves", 100, 100, 4, 4, 4);

        asuma.addJutsu(ashpile);
        asuma.addJutsu(flyingSwallow);
        asuma.addJutsu(thousandHandStrike);
        asuma.addNinjaTool(kunaiAsuma);
        asuma.addNinjaTool(shurikenAsuma);

        // Kakuzu setup
        Jutsu pressureDamage = new Jutsu("Ninjutsu", "Pressure Damage", "Wind Style", 40, "medium", 50);
        Jutsu falseLightning = new Jutsu("Ninjutsu", "False Lightning", "Lightning Style", 40, "medium", 50);
        Jutsu searingMigrane = new Jutsu("Ninjutsu", "Searing Migrane", "Fire Style", 40, "medium", 50);
        Jutsu earthSpear = new Jutsu("Defensive", "Earth Spear", "Earth Style", 25, "self", 0);

        Character kakuzu = new Character("Kakuzu", "Akatsuki", 200, 75, 4, 4, 4);

        kakuzu.addJutsu(pressureDamage);
        kakuzu.addJutsu(falseLightning);
        kakuzu.addJutsu(searingMigrane);
        kakuzu.addJutsu(earthSpear);

        // Hidan setup
        Character hidan = new Character("Hidan", "Akatsuki", 0, Integer.MAX_VALUE, 5, 5, 2);

        //Game Text
        String s ='\n' + "___________________________________________________________________________________________________" + '\n';
        String title = '\t' + "Welcome to the Naruto Text-Based-Game";
        String intro ="In this game we'll be exploring the Hidan/Kakuzu arc";
        System.out.println(title + s + intro + s);

        String s10 = "Tsunade: After the attack on the temple, we'll be dispatching squads to search for the Akatsuki." + '\n' + 
                    "         They distroyed the temple and defeated Chiriku, former member of the guardian shinobi twelve." + '\n' +
                    "         They are strong and dangerous, approach with caution" + '\n' + '\n' + "Go !!";
        String  s11 = "Asuma: The Akatsuki ha? We need to protect the king at all cost." + '\n' + 
                    "Shikamaru: The King? you mean the hokage?" + '\n' + "Asuma: no i mean the king" + '\n' + 
                    "Shikamaru: We don't have a king, what are you on about?" + '\n' + 
                    "Asuma: You remember when I taught you to play Shogi? And we discussed who each piece represents?" + '\n' +
                    "Shikamaru: Oh yea, you said I was the knight, but you never told me who was the king";
        System.out.println(s10 + s + s11 + s);

        String s20 = "Yamato: You just out of the hospital, are you sure you want to start training right away?" + '\n' + 
                    "Naruto: Forget about that, let's hurry up and create my new knockout Jutsu You know," + '\n' + 
                    "        We'll call it the Super Ultra Deluxe Rasengan, what do you think Kakashi sensei?" + '\n' + "Kakashi: ..." + '\n' + 
                    "Yamato: We're trying to add nature transformation to your Raseng.." + '\n' + 
                    "Naruto: My chakra nature is wind" + '\n' + 
                    "Kakashi: Ok... so let's try first applying wind chakra without change in chakra form, " + '\n' +
                    "         you'll need to cut that waterfall in half. Tenzo..." + '\n' +
                    "Yamato: Understood. Wood Style: Great Forest Emergence" + '\n' + 
                    "Kakashi: Naruto... " + '\n' + "Naruto: Multi Shadow Clone Jutsu";
        String s21 = "Kakashi: .... That was a nice nap. Naruto !! How you doing" + '\n' +
                    "Naruto: It's not enough, I have to catch up to Sasuke !!" + '\n' +
                    "Kakashi: hmm... *approaches Yamato and whispers*" + '\n' + 
                    "Yamato: Understood. Wood Style: Great Forest Emergence" + '\n' +
                    "Naruto: Shadow Clone Jutsu" + '\n' + "Kakashi: Let's keep going, you OK there Tenzo?" + '\n' + "Yamato: *coughs* I'm good I'm good";
        System.out.println(s20 + s + s21 + s);

        String s30 = "*Asuma, Shikamaru and the rest of their squad arrive at the Fire Temple and see sea of coffins." + '\n' + 
                    "There they meet the Elder Fire Priest*" + '\n' +
                    "Elder Fire Priest: You are leaf Shinobi, correct?" + '\n' + "Asuma: Yes sir" + '\n' + 
                    "Elder Fire Priest: We were contacted by the surviving monk that is now in your care. I was away with the feudal Lord" + '\n' + 
                    "                   when I heard what happened, I rushed back here. What a terrible sight" + '\n' +
                    "*As they walk up the stairs, they see a sea of coffins*" + '\n' +
                    "Asuma: Where is Chiriku's coffin?" + '\n' +
                    "Elder Fire Priest: It's not here. My aids have searched everywhere, but couldn't find his remains" + '\n' + 
                    "Izumo: Captian Asuma, I did't want to bring it up, but there's a 30 million ryo bounty on Chiriku's head" + '\n' + 
                    "Shikamaru: So if those Akatsuki guys know about the bounty, they are headed for a collection office" + '\n' + 
                    "Izumo: There are 5 total collection offices in the area" + '\n' + 
                    "Asuma: Send word to the Hokage about the collection offices, we'll be going to the nearest one. Let's go" + '\n' + 
                    "Elder Fire Priest: Lord Asuma Sarutobi, please allow me to say a prayer for you who are about to fight" + '\n' +
                    "Asuma: Thank you sir" + '\n' + 
                    "Elder Fire Priest: Please be careful Lord Asuma, being a former member of the Guardian Shinobi Twelve" + '\n' + 
                    "                   you also have a bounty on your head, just like Chiriku" + '\n' +
                    "Asuma: Don't worry about me, my bounty is 5 million ryo more than Chiriku's"
                    ;
        System.out.println(s30 + s);

        String s40 = "*Back at the training ground*" + '\n' + "Kakashi: I have something to show you naruto" + '\n' + "Naruto: What is it?" + '\n' +
                    "*Kakashi performs the Rasengan with one hand" + '\n' +
                    "Naruto: What?? You can perform my signature move with only one hand? While i need to create a shadow clone tp do it"+ '\n' +
                    "Kakashi: I'm not doing it to show off, I'm doing it to show you that the Rasengan is incomplete" + '\n' +
                    "Naruto: What do mean incomplete?" + '\n' +
                    "Kakashi: Well we both know that the Rasengan is the hoighest form of change in chakra form, right" + '\n' +
                    "Naruto: So I need add change in chakra nature" + '\n' +
                    "Kakashi: Exactly, but it's easier said than done. Even the inventor of this Jutsu, the Fourth Hokage, coldn't do it" + '\n' +
                    "Naruto: If the strongest Hokage couldn't. why do you think I can?" + '\n' + 
                    "Kakashi: Because I think that you can surpass the Fourth Hokage" + '\n' + "*As Kakashi walks away, Yamato whispers to him*" + '\n' + "Yamato: You really are a  slick talker" + '\n' +
                    "Kakashi: No... I really believe that";
        System.out.println(s40 + s);

        String s50 = "*Kakuzu and Hidan arrive at the Collection office*" + '\n' + "Clerk: So you got yourself a fat one ah Kakuzu" + '\n' + "Kakuzu: hmm" + '\n' + 
                    "Clerk: 30 million ryo, right there in the suitcase" + '\n' + "Hidan: C'mon Kakuzu let's leave this stinky place" + '\n' + 
                    "Kakuzu: I need to count the money first" + '\n' + "Hidan: I can't stand to be in here, I'll wait for you outside" + '\n' + 
                    "Clerk: Your partner has no respect for money, you should ditch him" + '\n' + 
                    "Kakuzu: He's the only one who CAN be my parter" + '\n' + "clerk: How's that?" + '\n' + 
                    "Kakuzo: Everyone that partners up with me ends up dead" + '\n' + s + '\n' + 
                    "*Hidan is sitting on the stairs of the collection office when he hears footsteps behind him*" + '\n' + 
                    "Are we done hear Kakuzu?" + '\n' + 
                    "Asuma: Not yet" + '\n' + "Hidan: Your'e not Kakuzu... wait, why can't I move?" + '\n' + 
                    "Shikamaru: Shadow Possesion Jutsu complete" + '\n' + "Asuma: NOW !!" + '\n' + 
                    "*Izumo and Kotetsu apear from both diractions stabing Hidan with their swords*" + '\n' + 
                    "Asuma: One down, one to go" + '\n' + 
                    "Hidan: You should have started with the other guy" + '\n' + 
                    "Izumo: What? How isn't he dead.... is he... Immortal?" + '\n' + "Hidan: That wasn't very nice of you" + '\n' + 
                    "*Suddenley Kakuzu apears from behind Shikamaru, striking at him. He dodge it at the last second*" + '\n' + 
                    "Asuma: Retreat on me !!" + '\n' + "Shikamaru: I'm good" + '\n' +  
                    "*Shikamaru Starts calculating: we have one guy that's immortal and one that is super strong, this doesn't look good for us*" + '\n' + 
                    "Hidan: Kakuzu !! Stay out it, I want to use those guys for my ritual" + '\n' + 
                    "Asuma: Shikamuru, follow my lead" + '\n' + 
                    "Shikamaru: Your'e not going with Climbimg silver are you" + '\n' +
                    "Asuma: Don't worry about that, let's go" + '\n' + "";

        combat(asuma, hidan);

        String s51 = "Asuma: This isn't working" + '\n' +
                    "*Hidan throws his scythe at Asuma, who manage to block it but not before it scarched his cheek" + '\n' +
                    "*Hidan smiles, licking Asuma's blood of the scythe*" + '\n' + 
                    "Asuma: We need a pinpoint attack. Fire Style: Burning Ash" + '\n' +
                    "Hidan: *Shouting form the Smoke* Hurts doesn't it?" + '\n' + "Asuma: My arm, how did this happen?" + '\n' +
                    "*The Smoke settles and suddenly Hidan's skin is black with skeletal marking in it*" + '\n' + 
                    "Hidan: Are you ready to feel the Ultimate Pain? Or shall we begin with something small? *Pulling a black rod from under his robe*" + '\n' + 
                    "*Hidan stabs himself in the leg*"+ '\n' + 
                    "Kotetsu: What? Why is Asuma bleeding in the leg?" + '\n' + 
                    "*Shikamaru Starts calculating*" + '\n' + 
                    "Shikamaru: It apears that Asuma's blood is connected to Hidan in some sort of curse, we need to find a way to reverse it" + '\n' + 
                    "Shikamaru: That circle in blood, it wasn't there before the attack, " + '\n' + 
                    "           that means that only by standing in the circle he can activate the curse" + '\n' +
                    "Izumo: Shikamaru you..." + '\n' +
                    "Shikamaru: Shadow Possesion Jutsu complete. Now I just need to move him out ot the circle..." + '\n' +
                    "Hidan: You brat !! Let go of me !!" + '\n' +
                    "*Shikamaru: Just a little bit more..." + '\n' +
                    "*Asuma comes in with his chakra blade and cut Hidan's head right off*" + '\n' +
                    "*As his head hits the ground, Hidan let's out a scream*" + '\n' +
                    "You bastard !! Kakuzu come here and help me out" + '\n' +
                    "*Kakuzu picks up Hidan's head, and approaches the rest of body to sew on the head*" + '\n' +
                    "Asuma: I won't let you !!" + '\n' + "*Kakuzu shows of his speed and kicks Asuma away*" + '\n' + "Izumo: Let's go Kotetsu" + '\n' +
                    "*Izumo and Kotetsu try to attack Kakuzu but he's just too fast and too strong*" + '\n' +
                    "Kakuzu: Now that the nuisance is taken care of, I'll put you back together you idiot" + '\n' +
                    "Hidan: Don't call me an idiot you idiot" + '\n' +
                    "*Shikamaru rushes in before Hidan steps into the circle*" + '\n' + "Shikamaru: ASUMA !!" + '\n' +
                    "*Hidan Stabs himself in the chest, and Asuma falls down*" + '\n' +
                    "*Suddenly a pack of crows swarms Kakuzu and Hidan*" + '\n' + "Choji: Now !!" + '\n' +
                    "*Choji, Ino and their team pick up Asuma and his team and fall back*" + '\n' +
                    "Hidan: What? Now? We're kinda busy right now" + '\n' +
                    "Choji: Are they communicating with someone?" + '\n' +
                    "Kakuzu: Hidan, let's go. We'll be back soon Konoha" + '\n' + s + '\n' +
                    "Shikamaru: Asuma... his heart is failing. Ino heal him with your medical Ninjutsu" + '\n' +
                    "Asuma: There nothing you can do, it's my time" + '\n' +
                    "       I finally understand what my father, the third Hokage meant" + '\n' +
                    "       Ino, your'e a strong and dependable womam, take care of Shikamru and Choji" + '\n' +
                    "       Choji, your'e a kind man who takes care of his friends, that's what makes you a stronger shinobi than me" + '\n' +
                    "       Shikamaru, your'e fit to be Hokage, if you weren't so lazy, lend me your ear so I could tell you abot the king" + '\n' +
                    "*Asuma whispers in his ear*" + '\n' +
                    "Asuma: Now if you don't mind, one last cigarette" + '\n' +
                    "*It starts raining as Asuma draws in his last puff*";
        System.out.println(s50 + s51 + s);

        String s60 = "*Team Asuma is gathered at the village gate*" + '\n' + "Shikamaru: Let's go" + '\n' + "Tsunade: Wait. What's going on here?" + '\n' +
                    "Shikamaru: The mission order is still in effect right? We formed a new team" + '\n' +
                    "Tsunade: I won't allow selfish actions. Shikamaru, you will join a new team and deploy after a plan is ready" + '\n' +
                    "Shikamaru: Just send support later, I already have a plan" + '\n' + 
                    "*Shikamaru is a genius tactician, second only to his father, a general for the leaf*" + '\n' +
                    "Tsunade: Enough !! Asuma is dead, only the three of you are le..." + '\n' +
                    "Shikamaru: Asuma is with us" + '\n' +
                    "Tsunade: Are you planning to avenge him in battle? This isn't like you, you are going to die out there" + '\n' +
                    "Shikamaru: I'm not stupid, I have no plan of dying, but..." + '\n' +
                    "           I don't want to give up without setting things right" + '\n' +
                    "Tsunade: Grow up... death haunts us Shinobi. And besides, there are only 3 of you..." + '\n' +
                    "Kakashi: So if I join them we can form a 4-member team" + '\n' +
                    "Ino: Kakashi sensei..." + '\n' +
                    "Kakashi: I will join as the captain of team 10, how about that Lady Tsunade?" + '\n' +
                    "Tsunade: Are you sure about this Kakashi?" + '\n' +
                    "Kakashi: You can't stop them, but if I go I could supervise them, make sure they don't go overboard" + '\n' +
                    "*The sun rises as Tsunade take a look at team Asuma*" + '\n' +
                    "Tsunade: Fine, go, but what about naruto's training?" + '\n' +
                    "Kakashi: Just send him and the rest of team 7 to support us when they are done";
        System.out.println(s60 + s);

        String s70 = "*Team 10 is searching for Hidan and Kakuzu*" + '\n' +
                    "Kakashi: I see, this is quite the plan Shikamaru" + '\n' +
                    "Shikamaru: Make sure to replay the plan at least twice in your heads. Kakashi sensei, use this when you get a chance" + '\n' +
                    "Kakashi: I see. Ino, your'e up" + '\n' +
                    "*Ino Uses the mind transfer Jutsu on a hawk, searching for the enemies*" + '\n' +
                    "Ino: 2 o'clock, in about ten minutes we'll catch up with them" + '\n' +
                    "*Team 10 hide behind Hidan and Kakuzu, while Shikamaru deploys his Shadow Possesion Jutsu*" + '\n' +
                    "Kakuzu: ... Hidan" + '\n' + "Hidan: I know" + '\n' +
                    "*They jump out of the way just as Shikamaru's shadow was approaching them*" + '\n' +
                    "Hidan: not this again" + '\n' + "* Shikamaru launches up in the air, throwing a pair of kunai with paper bombs*" + '\n' +
                    "Hidan: Kakuzu !!" + '\n' + "Kakuzu: I'm alright" + '\n' + "*Shikamaru throws again kunai with paper bombs, which they barely dodge*" + '\n' +
                    "Hidan: What? it didn't explode, what's going on here?" + '\n' +
                    "Kakuzu: Why can't we move? How? When?" + '\n' +
                    "Shikamaru: Shadow Possesion Shuriken Jutsu, complete" + '\n' + 
                    "           This kunai is made from a specail metal that absorbs the chakra of the user" + '\n' +
                    "           that ritual of yours, let's perform it on your partner" + '\n' + 
                    "*Shikamru uses his Jutsu to make hidan pick up his schyte and run towards Kakuzu*" + '\n' +
                    "Hidan: I know your face now, no matter what happens I'll kill you" + '\n' +
                    "Shikamaru your'e an idiot ha?" + '\n' +
                    "*Hidan slashes at Kakuzu, who dodges it at the last second*" + '\n' +
                    "Shikamru: Choji NOW !!" + '\n' + "Choji: Spiky Human Boulder Jutsu";

        String s71 = "*Sai and Sakura are at the training ground, watching naruto develop his new Jutsu*" + '\n' + "Sai: Naruto hasn't rested since Asuma's funeral" + '\n' +
                    "Sakura: He's Stubborn like that, once he sets his mind to something, he won't stop" + '\n' +
                    "       And besides, he has 24 hours to complete his Jutsu" + '\n' + "Sai: I see";

        String s72 = "*Choji's attack landed perfectly, creating a huge crater, but Kakuzu still rises up*" + '\n' +
                    "Ino: How? The attack hit him directly" + '\n' + "Shikamru: I see, he's hardening his body, which means we can't attack him diractly" + '\n' + 
                    "Hidan: Kakuzu, help me get out of his Jutsu" + '\n' + 
                    "*Suddenly Kakashi attacks Kakuzu from behind with his Light Blade*" + '\n' +
                    "Kakuzu: What? How did I not sense you?" + '\n' + "Kakashi: Your Hardening Jutsu is an earth nature Jutsu, which is weak againg my Lightning Blade" + '\n' +
                    "kakuzu: I see, you're Sharingan Kakashi" + '\n' + "Kakashi: You're done. Hidan, You're next" + '\n' +
                    "*Kakuzu gets up and kicks away Kakashi*" + '\n' + "Ino: That attack pierced his heart, how is it possible?" + '\n' +
                    "*Four wierd creatures crawl out of Kakuzu, but one falls apart immidiatly*" + '\n' + 
                    "Shikamaru: That one that fell apart, it was by Kakashi sensai's attack. Which means we need to take Kakuzu out 4 more times" + '\n' +
                    "Hidan: That idiot was acting all tough, I hope you're gonna take is seriously now Kakuzu" + '\n' + "Kakuzu: Let's go Hidan" + '\n' +
                    "*Hidan Attacks Kakshi with his schyte, who deflects his attcks with a kunai*" + '\n' + "Kakuzu: Wind Style: Pressure damage" + '\n' +
                    "Ino: Kakuzu's taking advantage of his partner's immortality and atacking through him" + '\n' + 
                    "*Kakuzu directs one of his creature at Shikamaru and Choji*" + '\n' +
                    "Kakuzu: Lightning Style: False Lightning" + '\n' + "*Kakashi apears out of the blue and absorbs the attack using his own lightning style*" + '\n' +
                    "Choji: Are you ok Kakashi Sensei" + '\n' + "Kakashi: I'm fine. Here Shikamaru take this" + '\n' + "*Kakashi hands him the thing from the breefing*" + '\n' +
                    "Kakashi: What's the plan Shikimaru?" + '\n' + "Shikamaru: We seperate them, I'll take Hidan, and after that Choji and Ino will support Kakashi sensei" + '\n' +
                    "*Shikamaru walks forward, getting closer so he could use his Jutsu*" + '\n' + "Hidan: Not this again, your'e boring" + '\n' + 
                    "*Kakashi attacks Kakuzu*" + '\n' + "Kakashi: I'm your opponent" + '\n' + "*Kakashi and Kakuzu exchange blows while Shikamaru tries to connect with his Jutsu*" + '\n' +
                    "Hidan: Your'e not gonna make it this time" + '\n' + "*He sees a spark flying at him*" + '\n' + "Hidan: What? He throw that kunai with his shadow?" + '\n' +
                    "*Hidan jumps away from the first kunai, but he sees another is also flying at him*" + '\n' + "Hidan: It's gonna get me mid air" + '\n' +
                    "*Hidan thrusts his schyte in the tree and stands on it*" + '\n' + "Hidan: Phew that was close, now where is that little bugger that plays in the shadows?" + '\n' +
                    "*Shikamaru jumps from behind the tree and punches at Hidan, knowing that Hidan's only defence is his body, not his blades*" + '\n' + "Shikamaru: I'm right here !!" + '\n' +
                    "*When they made contact, their shadows did as well, just as Shikammaru planned it*" + '\n' + "Shikamaru: Shadow Possesion Jutsu complete. Now How about a little walk?" + '\n' +
                    "*Shikamaru takes Hidan into the forest*";

        String s73 = "*Shikamaru takes Hidan deep into the forest and starts throwing kinai with paper bombs and wires around Hidan*" + '\n' +
                    "Hidan: What are you doing? What's your plan" + '\n' + "Shikamaru: You'll see" + '\n' + "Hidan: You won't let me get away ha?"+ '\n' +
                    "*Shikamaru looks worried, but continues throwing the kunai, creating a jungle of wires and paper bombs*" + '\n' +
                    "*Hidan sees that the shadow binding him grows weaker and weaker, until it disappears*" + '\n' + "Hidan: Your'e Jutsu lasts for only 5 minutes, your times is up kid" + '\n' +
                    "*He whips out his black rod and charges at Shikamaru, scratching him on the cheek. Shikamaru knows what it means as he lays on the ground*" + '\n' +
                    "Hidan: You idiot !! I'm gonna perform my ritual on you and mke you regret messing with me" + '\n' + "*He draws the circle with Shikamaru's blood, his skin turns black*" + '\n' +
                    "Hidan: This is where you die !!" + '\n' + "*Hidan stabs himself in chest*";

        String s74 = "Kakuzu: Even though your plan to seperate us was right, someone really should go with that shadow kid." + '\n' +
                    "       I remember the first time i fought a Leaf shinobi, It was the first Hokage, Hashirama Senju" + '\n' +
                    "Ino: How could that be? He died over 70 years ago, that would make him 90+" + '\n' + 
                    "Kakuzu: I was sent by my village to kill the first Hokage, and when I failed, I was cast out by my village elders" + '\n' +
                    "       So I killed them. Killed them and took their hearts, and those hearts are the creatures that you see." + '\n' +
                    "       And I will have your heart to replace the one you destroyed, Kakashi." + '\n' +
                    "*Two of Kakuzu's creatures merge into one, creating a more powerful monster*. It attacks Kakashi, destroying a large area in the Proccess" + '\n' +
                    "Kakuzu: You call that hiding??" + '\n' +
                    "Kakashi: Se his plan is to draw me into an open area, so he'll have a numbers advantage on me" + '\n' +
                    "Kakuzu: Wind Style: Pressure Damage" + '\n' + "*Kakashi dodges the intial barrage, but gets hit*" + '\n' +
                    "Choji: Kakashi Sensei No !!" + '\n' + "*Kakashi's body turns into a stump*" + '\n' + "Kakuzu: A substitution ha? Where Are you hiding?" + '\n' +
                    "*Kakshi emerges from a hole in the ground, pulling one of Kakuzu's monster into it*" + '\n' + 
                    "Kakuzu: That was a nice trick but how are you gonna counter this one?" + '\n' + "*The monster attacks with fire and air styles, amplifying the damage*" + '\n' +
                    "Kakashi: Water Style: Water Wall" + '\n' + "*He's blown back from that attack*" + '\n' +
                    "Kakshi: Water syle alone won't be enough to fight that thing" + '\n' + "*Kakuzu suddenly emerges from the smoke and knocks down Kakashi, pinning him to the ground*" + '\n' +
                    "Kakuzu: This is it Kakashi, this is where I take you heart";
                    
        String s75 = "Hidan: It's addicting isn't it? The ultimate PAIN !!" + '\n' +
                    "*Shikamaru remebers Asuma's last words to him: I'm counting on you*" + '\n' +
                    "Hidan: What a worthless sacrifice, I wonder if Kakuzu is finished up there"; 

        String s76 = "Kakuzu: What did you do?" + '\n' + "Kakashi: Seems like Shikamru is right in time" + '\n' + 
                    "*Kakuzu falls next to Kakashi, with his hand still on Kakashi's heart*"; 
        
        String s77 = "*Hidan starts walking back*" + '\n' + "Shikamaru: Shadow Possesion Jutsu" + '\n' + "Hidan: How is possible? Your'e supposed to be dead" + '\n' +
                    "Shikamaru: It was planed from the start. When Kakashi first attacked Kakuzu, he drew some of his blood, and gave me the container" + '\n' +
                    "           I spilled the blood on your rod when you attacked me, forcing you to perform your ritual on you partner." + '\n' +
                                "Shadow Pull Jutsu" + '\n' + "*All the wires tangle atound Hidan, suspending him from the ground. Then a deep deep hole opens up right under him*" + '\n' +
                                "Hidan: You didn't just happen to bring me here, this is all part of plan" + '\n' + 
                                "Shikamaru: That's right. You know, when you curse someone, you need to dig two graves, but don't worry about yours, it's right there" + '\n' +
                                "Hidan: Did you forget that I'm immortal?? I'll dig my way out of it and come back to kill you, you idiot" + '\n' +
                                "Shikamaru: These woods are a sacred place in the Land of fire, and they belong to my clan" + '\n' + 
                                "           We're the only ones allowed here, and always watching the place" + '\n' + 
                                "*Shikamaru tries to light Asuma's lighter, but can't seem to do it. He feels Asuma's hand on his shoulder, he's smiling at him*" + '\n' +
                                "*He lights up the lighter, throwing it at the paper bombs, collapsing Hidan into the pit*" + '\n' + 
                                "*Hidan cries from the pit*" + '\n' + "Hidan: I'll kill you !! Lord Jashin will punish you severly for this !!" + '\n' +
                                "Shikamaru: I don't believe in you Jashin, I believe in the Will of Fire. This is for Asuma" + '\n' + 
                                "*Shikamaru throws a kunai paper bomb to the side of the pit, collapsing it into itself*";

        String s78 = "Kakashi: It was the plan from the start, have your partner perform his thing with your blood" + '\n' +
                    "Kakuzu: How could i fall for that trick?" + '\n' + "Kakashi: You underestimated him, and kill his sensei, your end was decided from the get go" + '\n' +
                    "Kakuzu: You leave me no choice" + '\n' + "*Kakuzu's monsters fly back into his body, merging with him. It looks like he has 3 heads now*" + '\n' +
                    "Kakuzu: No one has seen me in Kaku-mode for a while now" + '\n' + "*Kakuzu sends the wires from his arm and wraps them around Ino's, Choji's and Kakashi's throats*" + '\n' +
                    "Kakuzu: My original plan was to take your hearts, but now, I'll kill you where you stand" + '\n' + 
                    "Yamato: Water Style: Ripping Torrent" + '\n' + "Naruto: Rasengan" + '\n' + "*Naruto and Yamato create a vortex-like Jutsu that free their freinds from Kakuzu's hold*" + '\n' +
                    "Kakashi: Thanks guy. Yamato, did he do it?" + '\n' + "Yamato: Yes, but it's still not consistant" + '\n' +
                    "Naruto: Leave this to me";
        System.out.println(s60 + s + s70 + s + s71 + s + s72 + s + s73 + s + s74 + s75 + s + s76 + s + s77 + s + s78 + s);
        
        combat(naruto,kakuzu);

        String s80 = "Naruto: I'll finish him with my new technique, shadow clone Jutsu" + '\n' + 
                    "*Two shadow clones appear, one is helping for the rasengan, the other is adding wid chakra to it*" + '\n' +
                    "Naruto: Let's go" + '\n' + "*Naruto sends the schadow clones first for diversion, but Kakuzu sees right through it*" + '\n' +
                    "Kakuzu: I can ignore the first two" + '\n' + "*Kakuzu leaps into the air over the two clones and attacks naruto with all his strength*" + '\n' +
                    "Kakashi: I knew he'd attack with a long range Jutsu" + '\n' + "*When the dust settles, Kakuzu sees Naruto's body, for a second before it disappers*" + '\n' +
                    "Kakuzu: A shadow clone? He mixed himself with the diversion" + '\n' + "*Naruto appears from behind him, mid air*" + '\n' +
                    "Naruto: Wind Style: Rasen-Shuriken" + '\n' + "Kakashi: 1,2,5,18... even with my sharingan i can't count all the blades, there must be at least a thousand" + '\n' +
                    "*Naruto lands, Kakuzu crashes into the ground*" + '\n' + "Kakashi: There's still one more heart, I'll finish him for good" + '\n' + "*Kakashi approaches Kakuzu*" + '\n' +
                    "Kakuzu: How could that be? How could I lose to a bunch of brats like you? I once fought Hashirama Senju himself !!" + '\n' +
                    "Kakashi: We may seem like young brats to you, but to us your'e a washed up old man." + '\n' + 
                    "         One after the other, a new generation will surpass us";
        System.out.println(s80);

}
}