import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ClubsTab extends JFrame {
    private JPanel clubListPanel;
    public static Club DDT = new Club("DDT", "Dance", "Friday, Sunday", "2:00 PM",
            true, "Dilni Pathirana","Welcome to DDT, where the beats never stop and the energy never fades! Nestled in the heart of the city, DDT is a pulsating dance haven that transcends the ordinary club experience. Step into a realm where the music is the ultimate conductor, guiding you through an electrifying journey of rhythm and movement.\n" +
            "\n" +
            "As you enter DDT, you'll be enveloped by an atmosphere teeming with excitement and anticipation. Neon lights cascade across the sleek, futuristic decor, casting a vibrant glow over the dance floor. The air is alive with the thumping basslines and infectious melodies curated by our expert DJs, who specialize in crafting the perfect sonic landscape to keep you grooving all night long.\n" +
            "\n" +
            "But DDT isn't just about the music—it's about the immersive experience. Lose yourself in the mesmerizing visual displays that adorn every corner, from dazzling light shows to cutting-edge projections that dance in sync with the music. Our state-of-the-art sound system ensures that every beat resonates deep within your soul, creating a euphoric sensation that transcends the boundaries of reality.\n" +
            "\n" +
            "And let's not forget about our signature cocktails! Quench your thirst with an array of meticulously crafted drinks served by our talented mixologists. From classic concoctions to innovative libations inspired by the latest dance trends, there's something to satisfy every palate at DDT.\n" +
            "\n" +
            "Whether you're a seasoned dancer or just looking to let loose and have a good time, DDT welcomes you with open arms. Join us for an unforgettable night of music, magic, and memories that will keep you coming back for more. So what are you waiting for? Come experience the thrill of DDT and let the rhythm move you like never before!", "dpathirana@colgate.edu");
    public static Club MathClub = new Club("Math Club", "Math", "Monday, Wednesday", "4:00 PM",
            false, "John Doe","Welcome to MathClub, where equations are our beats and numbers are our dancers! Step into a world where the rhythm of mathematics sets the pace for an exhilarating intellectual journey unlike any other. Nestled in the heart of the city, MathClub is the ultimate destination for those who seek to elevate their passion for numbers to new heights.\n" +
            "\n" +
            "As you enter MathClub, prepare to be captivated by an atmosphere that pulses with the excitement of mathematical discovery. From the moment you set foot inside, you'll be surrounded by the sights and sounds of numerical elegance. Elegant geometric patterns adorn the walls, serving as a visual ode to the beauty of mathematics.\n" +
            "\n" +
            "But the true magic of MathClub lies in its intellectual allure. Immerse yourself in thought-provoking discussions led by our esteemed hosts, who are experts in their respective fields of mathematics. Explore the depths of number theory, unravel the mysteries of calculus, and delve into the infinite possibilities of mathematical logic.\n" +
            "\n" +
            "But MathClub isn't all serious business—we know how to have fun too! Challenge your friends to mind-bending puzzles and games designed to test your mathematical prowess. Whether you're a seasoned mathematician or just starting out on your journey, there's something for everyone at MathClub.\n" +
            "\n" +
            "And of course, no mathematical adventure would be complete without refreshments to fuel your intellect. Indulge in a variety of themed snacks and beverages inspired by the world of mathematics, from pi-shaped pastries to fractal-inspired cocktails.\n" +
            "\n" +
            "So whether you're a math prodigy or simply curious about the wonders of numbers, MathClub invites you to join us for an unforgettable evening of exploration, discovery, and above all, fun. Come dance to the rhythm of mathematics and let your imagination soar to new mathematical heights at MathClub!","jdoe@colgate.edu");
    public static Club ChemClub = new Club("Chemistry Club", "Chemistry", "Tuesday, Thursday",
            "3:00 PM", false, "Jane Smith", "Welcome to ChemClub, where molecules mingle and reactions reign supreme! Tucked away in the heart of the city, ChemClub is a haven for those who are passionate about the wonders of chemistry. Step inside and prepare to be transported into a world where atoms dance and compounds collide in a symphony of scientific delight.\n" +
            "\n" +
            "As you enter ChemClub, you'll be greeted by an atmosphere alive with the spirit of scientific inquiry. The décor pays homage to the periodic table, with elements adorning the walls and molecular structures suspended from the ceiling. It's a visual feast for the chemically inclined!\n" +
            "\n" +
            "But the true magic of ChemClub lies in its interactive experiences. Engage in hands-on experiments led by our knowledgeable hosts, who will guide you through the fascinating world of chemical reactions. From colorful titrations to mesmerizing demonstrations of chemical kinetics, there's no shortage of excitement to be found at ChemClub.\n" +
            "\n" +
            "But don't worry, we haven't forgotten about the social aspect! Mix and mingle with fellow chemistry enthusiasts as you sip on specialty cocktails inspired by the periodic table. Whether you're indulging in a \"Carbon Cosmo\" or a \"Lithium Lemonade,\" you'll find that our concoctions are as creative as they are delicious.\n" +
            "\n" +
            "And for those craving a mental challenge, put your chemistry knowledge to the test with trivia nights and quizzes that will leave your brain buzzing with excitement. With topics ranging from organic chemistry to biochemistry and beyond, there's always something new to learn at ChemClub.\n" +
            "\n" +
            "So whether you're a seasoned chemist or just starting to explore the world of molecules, ChemClub invites you to join us for an unforgettable evening of scientific exploration, camaraderie, and above all, fun. Come discover the magic of chemistry and let your curiosity ignite at ChemClub!","jsmith@colgate.edu");
    public static Club ArtClub = new Club("Art Club", "Art", "Saturday", "1:00 PM",
            false, "Alice Johnson", "Welcome to ArtClub, where creativity knows no bounds and imagination takes center stage! Nestled in the heart of the city, ArtClub is a vibrant sanctuary for artists and art enthusiasts alike. Step into a world where every brushstroke tells a story and every color evokes emotion, as we celebrate the boundless beauty of artistic expression.\n" +
            "\n" +
            "As you enter ArtClub, you'll be greeted by an atmosphere teeming with inspiration. The walls are adorned with eclectic artwork from local talents, showcasing a diverse array of styles and mediums. From avant-garde sculptures to whimsical paintings, there's something to captivate every artistic soul.\n" +
            "\n" +
            "But ArtClub is more than just a gallery—it's a hub of creativity where imagination flourishes. Join us for interactive art workshops led by seasoned artists, who will help you unleash your inner muse and explore new techniques and mediums. Whether you're a novice or a seasoned pro, there's always something new to discover at ArtClub.\n" +
            "\n" +
            "And let's not forget about the social aspect! Mix and mingle with fellow art lovers as you sip on specialty cocktails inspired by famous artists and art movements. From \"Van Gogh's Starry Nightcap\" to \"Picasso's Palette Punch,\" our drinks are as creative as they are delicious.\n" +
            "\n" +
            "But the creativity doesn't stop there! Immerse yourself in live art performances that blur the lines between reality and imagination. From live painting sessions to interactive installations, you'll be amazed by the endless possibilities of artistic expression.\n" +
            "\n" +
            "So whether you're a painter, sculptor, or simply appreciate the beauty of creativity, ArtClub invites you to join us for an unforgettable evening of artistic exploration, camaraderie, and above all, fun. Come unleash your imagination and let your creativity soar at ArtClub!","ajohnson@colgate.edu");
    public static Club MusicClub = new Club("Music Club", "Music", "Wednesday, Friday",
            "5:00 PM", true, "Bob Brown", "Welcome to SoundScape, where the rhythm of life pulses through every beat! Located in the heart of the city, SoundScape is not just a club—it's a sanctuary for music lovers of all genres and backgrounds. Step inside and immerse yourself in a world where melodies mingle and harmonies dance, creating an unforgettable symphony of sound.\n" +
            "\n" +
            "As you enter SoundScape, you'll be greeted by an atmosphere alive with the energy of live music. From the moment you step through the doors, you'll feel the bass reverberating through your bones and the melodies stirring your soul. Our stage hosts a diverse lineup of talented musicians, ranging from local indie bands to renowned international artists, ensuring that every night is a unique and unforgettable experience.\n" +
            "\n" +
            "But SoundScape isn't just about the performances—it's about the music community. Join fellow music enthusiasts in our cozy lounges and vibrant dance floors as you share your passion for all things musical. Whether you're discussing the latest album releases or trading stories of your favorite concert experiences, you'll find a welcoming and inclusive atmosphere at SoundScape.\n" +
            "\n" +
            "And let's not forget about the drinks! Sip on expertly crafted cocktails and ice-cold brews as you groove to the rhythm of the music. From classic cocktails to specialty concoctions inspired by your favorite artists, our bar has something to satisfy every palate.\n" +
            "\n" +
            "But the party doesn't stop there! Get ready to dance the night away with our resident DJs, who spin the hottest tracks and remixes until the early hours of the morning. Whether you're into hip-hop, EDM, rock, or pop, our DJs have the perfect playlist to keep you moving and grooving all night long.\n" +
            "\n" +
            "So whether you're a die-hard music fanatic or simply looking for a night of fun and excitement, SoundScape invites you to join us for an unforgettable evening of live music, camaraderie, and above all, pure musical magic. Come experience the heartbeat of the city at SoundScape—where every note tells a story and every beat brings us together in harmony.","bbrown@colgate.edu");
    public static Club TheaterClub = new Club("Theater Club", "Theater", "Monday, Wednesday, Friday",
            "6:00 PM", true, "Sarah Lee","Welcome to TheaterClub, where the spotlight shines brightest and the stage comes alive with the magic of performance! Nestled in the heart of the city's arts district, TheaterClub is a haven for theater enthusiasts, actors, and anyone who appreciates the transformative power of live performance.\n" +
            "\n" +
            "As you step into TheaterClub, you'll be enveloped by an atmosphere that exudes the rich history and timeless allure of the theater. The walls are adorned with posters from iconic productions, and the air is filled with the anticipation of the next great performance. Whether you're a seasoned theatergoer or a newcomer to the stage, TheaterClub welcomes you with open arms.\n" +
            "\n" +
            "But TheaterClub isn't just a venue—it's a community. Join fellow theater lovers in our cozy lounge areas, where you can discuss your favorite shows, share acting tips, or simply bask in the camaraderie of like-minded individuals. Whether you're a playwright, actor, director, or avid audience member, you'll find a home at TheaterClub.\n" +
            "\n" +
            "And of course, no theater experience would be complete without refreshments to fuel your passion for the arts. Indulge in a variety of themed cocktails and gourmet snacks inspired by classic plays and musicals. From \"Romeo's Romance\" to \"Oscar Wilde's Wit,\" our drinks are as creative as the performances on our stage.\n" +
            "\n" +
            "Speaking of performances, get ready to be dazzled by our lineup of captivating shows and events. From thought-provoking dramas to toe-tapping musicals, our stage plays host to a diverse array of productions that will leave you spellbound. Whether you're in the mood for comedy, tragedy, or something in between, TheaterClub has something for everyone.\n" +
            "\n" +
            "So whether you're a theater aficionado or simply looking for a night of entertainment and culture, TheaterClub invites you to join us for an unforgettable evening of live performance, camaraderie, and above all, the pure magic of the theater. Come experience the thrill of the stage at TheaterClub—where every performance is a masterpiece in the making." ,"slee@colgate.edu");
    public static Club SportsClub = new Club("Sports Club", "Sports", "Tuesday, Thursday",
            "4:00 PM", false, "Tom Green","Welcome to Sports Club, where the thrill of competition meets the camaraderie of teamwork! Situated in the heart of the city, Sports Club is a dynamic hub for athletes, sports enthusiasts, and anyone who revels in the excitement of the game.\n" +
            "\n" +
            "As you step into Sports Club, you'll be greeted by an atmosphere brimming with the energy of athletic excellence. The walls are adorned with memorabilia from legendary sports moments, and the air is alive with the sound of cheering fans and the echo of sneakers on the court. Whether you're a seasoned athlete or a casual spectator, Sports Club offers something for everyone.\n" +
            "\n" +
            "But Sports Club isn't just about watching games—it's about getting in on the action! Join fellow sports enthusiasts in our state-of-the-art facilities, where you can compete in a variety of sports and activities. From basketball and volleyball to tennis and soccer, there's no shortage of opportunities to break a sweat and showcase your skills.\n" +
            "\n" +
            "And for those who prefer to spectate, our spacious viewing areas provide the perfect vantage point to catch all the action. Whether you're cheering on your favorite team or marveling at the athleticism on display, you'll find yourself immersed in the excitement of the game.\n" +
            "\n" +
            "But the fun doesn't stop there! Sports Club also offers a range of social events and activities designed to bring the community together. From sports-themed trivia nights to meet-and-greets with professional athletes, there's always something happening at Sports Club to keep you engaged and entertained.\n" +
            "\n" +
            "And of course, no sports experience would be complete without refreshments to fuel your passion for the game. Indulge in a variety of hearty snacks and energizing drinks as you cheer on your team or celebrate your victories with friends.\n" +
            "\n" +
            "So whether you're a seasoned athlete or just looking to enjoy the thrill of the game, Sports Club invites you to join us for an unforgettable evening of sportsmanship, camaraderie, and above all, fun. Come experience the excitement of Sports Club—where every game is a chance to make memories that last a lifetime.", "tgreen@colgaet.edu");
    public static Club HipHopClub = new Club("Hip Hop Club", "Dance", "Monday, Wednesday",
            "7:00 PM", true, "Emily White","Welcome to HypeHopClub, where the rhythm of the streets meets the pulse of the underground! Situated in the heart of the city, HypeHopClub is the ultimate destination for hip-hop aficionados, urban culture enthusiasts, and anyone who thrives on the energy of the hip-hop scene.\n" +
            "\n" +
            "As you step into HypeHopClub, you'll be immersed in an atmosphere that exudes the raw energy and creativity of hip-hop culture. Graffiti art adorns the walls, DJ turntables stand ready at the center stage, and the air is filled with the infectious beats of the latest hip-hop tracks. Whether you're a seasoned MC or just love to vibe to the rhythm, HypeHopClub welcomes you with open arms.\n" +
            "\n" +
            "But HypeHopClub isn't just about the music—it's about the entire hip-hop experience. Join fellow hip-hop heads in our dance area, where you can bust a move to the hottest beats spun by our resident DJs. From classic tracks to underground hits, our DJs know how to keep the party going all night long.\n" +
            "\n" +
            "And for those who prefer to showcase their lyrical prowess, our open mic nights provide the perfect opportunity to spit rhymes and drop bars. Whether you're a seasoned emcee or a newcomer to the mic, the stage is yours to command as you share your passion for hip-hop with the crowd.\n" +
            "\n" +
            "But the fun doesn't stop there! HypeHopClub also hosts a variety of events and activities designed to celebrate the culture and creativity of hip-hop. From graffiti art battles to breakdance competitions, there's always something happening at HypeHopClub to keep you entertained and engaged.\n" +
            "\n" +
            "And of course, no hip-hop experience would be complete without refreshments to fuel your passion for the music. Indulge in a variety of street-inspired snacks and signature cocktails as you soak in the vibes and connect with fellow hip-hop enthusiasts.\n" +
            "\n" +
            "So whether you're a die-hard hip-hop head or just looking to experience the culture firsthand, HypeHopClub invites you to join us for an unforgettable evening of beats, rhymes, and above all, the pure essence of hip-hop. Come experience the energy of HypeHopClub—where every moment is a celebration of the culture that moves us all.", "ewhite@colgate.edu");
    public static Club SwingDanceClub = new Club("Swing Dance Club", "Dance", "Tuesday, Thursday",
            "5:00 PM", true, "Chris Black", "Welcome to SwingSociety, where the rhythm swings and the dance floor comes alive with the spirit of jazz! Nestled in the heart of the city, SwingSociety is a haven for swing dance enthusiasts, jazz aficionados, and anyone who loves to cut a rug to the infectious sounds of the swing era.\n" +
            "\n" +
            "As you step into SwingSociety, you'll be transported back to the golden age of swing, where big bands ruled the airwaves and dance halls were the place to be. The décor harkens back to the glamorous days of the 1920s and 1930s, with vintage posters adorning the walls and the unmistakable sound of swing music filling the air.\n" +
            "\n" +
            "But SwingSociety isn't just a venue—it's a community. Join fellow swing dance enthusiasts on our spacious dance floor, where you can twirl, spin, and strut your stuff to the timeless melodies of the swing era. Whether you're a seasoned dancer or just learning the steps, SwingSociety offers a welcoming and inclusive environment where everyone can join in the fun.\n" +
            "\n" +
            "And for those who prefer to watch the action unfold, our cozy seating areas provide the perfect vantage point to soak in the sights and sounds of the dance floor. Whether you're admiring the fancy footwork of the pros or simply tapping your toes to the beat, you'll find yourself swept away by the infectious energy of SwingSociety.\n" +
            "\n" +
            "But the fun doesn't stop there! SwingSociety also hosts a variety of events and activities designed to celebrate the joy and camaraderie of swing dance culture. From swing dance workshops to live performances by talented jazz musicians, there's always something happening at SwingSociety to keep you entertained and engaged.\n" +
            "\n" +
            "And of course, no swing dance experience would be complete without refreshments to fuel your passion for the dance. Indulge in a variety of vintage-inspired cocktails and classic snacks as you mingle with fellow swing dance enthusiasts and soak in the vibrant atmosphere of SwingSociety.\n" +
            "\n" +
            "So whether you're a seasoned swing dancer or just looking to experience the magic of the swing era, SwingSociety invites you to join us for an unforgettable evening of music, dance, and above all, the pure joy of swing. Come swing with us at SwingSociety—where every step is a celebration of the timeless rhythms that bring us together.","cblack@colgate.edu");
    public static Club FootballClub = new Club("Football Club", "Sports", "Monday, Wednesday, Friday",
            "5:00 PM", false, "Mike Brown", "Welcome to GridironGrove, where the roar of the crowd and the clash of helmets create an electrifying atmosphere unlike any other! Located in the heart of the city, GridironGrove is the ultimate destination for football fanatics, sports enthusiasts, and anyone who loves the thrill of game day.\n" +
            "\n" +
            "As you step into GridironGrove, you'll be immersed in an atmosphere that embodies the spirit of football. The walls are adorned with jerseys and memorabilia from legendary teams and players, and the air is alive with the excitement of the gridiron. Whether you're a die-hard fan or just love the energy of game day, GridironGrove welcomes you with open arms.\n" +
            "\n" +
            "But GridironGrove isn't just a venue—it's a community. Join fellow football aficionados in our spacious viewing areas, where you can catch all the action on our giant screens. Whether you're cheering on your favorite team or analyzing the plays with fellow fans, you'll find yourself swept up in the excitement of the game.\n" +
            "\n" +
            "And for those who prefer to take the field themselves, GridironGrove offers state-of-the-art facilities for pickup games and flag football tournaments. Lace up your cleats, gather your teammates, and get ready to show off your skills on the turf.\n" +
            "\n" +
            "But the fun doesn't stop there! GridironGrove also hosts a variety of events and activities designed to celebrate the camaraderie and competitiveness of football. From tailgate parties to meet-and-greets with former players, there's always something happening at GridironGrove to keep you entertained and engaged.\n" +
            "\n" +
            "And of course, no football experience would be complete without refreshments to fuel your passion for the game. Indulge in a variety of game day favorites, from hot dogs and nachos to ice-cold beers and specialty cocktails, as you cheer on your team and celebrate the victories with friends.\n" +
            "\n" +
            "So whether you're a seasoned quarterback or just love the excitement of game day, GridironGrove invites you to join us for an unforgettable experience of football, camaraderie, and above all, the pure thrill of the game. Come kick off the excitement at GridironGrove—where every day is game day!","mbrown@colgate.edu");
    public static Club BasketballClub = new Club("Basketball Club", "Sports", "Tuesday, Thursday",
            "6:00 PM", false, "Sara Green","Welcome to HoopHaven, where the sound of sneakers squeaking on the court and the swish of the net create an electrifying atmosphere that basketball enthusiasts can't resist! Situated in the heart of the city, HoopHaven is the ultimate destination for basketball fans, players, and anyone who loves the fast-paced action of the game.\n" +
            "\n" +
            "As you step into HoopHaven, you'll be surrounded by an ambiance that embodies the essence of basketball culture. The walls are adorned with iconic jerseys and memorabilia from legendary players and teams, and the air is filled with the energy of anticipation. Whether you're a seasoned player or just enjoy shooting hoops, HoopHaven welcomes you with open arms.\n" +
            "\n" +
            "But HoopHaven isn't just a venue—it's a community. Join fellow basketball enthusiasts on our state-of-the-art courts, where you can showcase your skills, engage in pickup games, or participate in organized leagues and tournaments. Whether you're perfecting your jump shot or working on your defense, HoopHaven provides the perfect environment to hone your basketball prowess.\n" +
            "\n" +
            "And for those who prefer to watch the action unfold, our spacious viewing areas offer the perfect vantage point to catch all the excitement. Whether you're cheering on your favorite team or marveling at the athleticism on display, you'll find yourself immersed in the thrill of the game at HoopHaven.\n" +
            "\n" +
            "But the fun doesn't stop there! HoopHaven also hosts a variety of events and activities designed to celebrate the camaraderie and competitiveness of basketball. From skills clinics and coaching sessions to slam dunk contests and three-point shootouts, there's always something happening at HoopHaven to keep you entertained and engaged.\n" +
            "\n" +
            "And of course, no basketball experience would be complete without refreshments to fuel your passion for the game. Indulge in a variety of game day favorites, from hot dogs and nachos to ice-cold drinks and specialty cocktails, as you cheer on your team and celebrate the victories with friends.\n" +
            "\n" +
            "So whether you're a seasoned baller or just love the excitement of the game, HoopHaven invites you to join us for an unforgettable experience of basketball, camaraderie, and above all, the pure love of the sport. Come shoot hoops and make memories at HoopHaven—where every game is a slam dunk!\n"
            , "sgreen@colgate.edu");
    public static Club PepBand = new Club("Pep Band", "Music", "Friday", "7:00 PM",
            false, "Alex Johnson", "Welcome to PepBeat, where the rhythm of the crowd and the pulse of the music combine to create an unbeatable atmosphere of excitement and energy! Nestled in the heart of the city, PepBeat is the ultimate destination for pep band enthusiasts, music lovers, and anyone who thrives on the thrill of live performances.\n" +
            "\n" +
            "As you step into PepBeat, you'll be enveloped by an atmosphere that exudes the spirit of school pride and musical camaraderie. The walls are adorned with instruments and memorabilia from past performances, and the air is alive with the sounds of brass, percussion, and woodwinds coming together in perfect harmony. Whether you're a seasoned musician or just love the energy of pep band music, PepBeat welcomes you with open arms.\n" +
            "\n" +
            "But PepBeat isn't just a venue—it's a community. Join fellow pep band enthusiasts in our spirited rehearsals, where you can fine-tune your skills, learn new music, and bond with fellow musicians who share your passion for performance. Whether you're playing the trumpet, trombone, saxophone, or drums, PepBeat provides the perfect environment to showcase your talents and make lasting connections.\n" +
            "\n" +
            "And when it's time to take the stage, PepBeat shines as the ultimate showcase for pep band excellence. Whether you're performing at sporting events, pep rallies, parades, or other special occasions, PepBeat ensures that your music is heard loud and clear, inspiring cheers and applause from audiences far and wide.\n" +
            "\n" +
            "But the fun doesn't stop there! PepBeat also hosts a variety of events and activities designed to celebrate the camaraderie and creativity of pep band culture. From themed performances and pep rallies to community outreach events and musical workshops, there's always something happening at PepBeat to keep you entertained and engaged.\n" +
            "\n" +
            "And of course, no pep band experience would be complete without refreshments to fuel your passion for the music. Indulge in a variety of snacks and beverages as you bond with fellow musicians and celebrate the power of music to unite and uplift.\n" +
            "\n" +
            "So whether you're a seasoned pep band veteran or just love the excitement of live performances, PepBeat invites you to join us for an unforgettable experience of music, camaraderie, and above all, the pure joy of making music together. Come join the band at PepBeat—where every performance is a celebration of school spirit and musical excellence!","ajohnson@coglate.edu");
    public static Club[] clubs = {DDT, MathClub, ChemClub, ArtClub, MusicClub, TheaterClub, SportsClub, HipHopClub,
            SwingDanceClub, FootballClub, BasketballClub, PepBand};
    public ClubsTab() {
        setTitle("Clubs Tab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Load and resize the background image
        BufferedImage resizedImage = resizeImage("clubsbackground.png", 400, 600);
        ImageIcon backgroundImage = new ImageIcon(resizedImage);

        // Set background image
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 400, 600);
        setContentPane(background);

        // Top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBounds(0, 0, 400, 20);
        topBar.setOpaque(false);
        background.add(topBar);

        // Left button
        JButton leftButton = new JButton();
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 1
                new Profile();
            }
        });
        leftButton.setPreferredSize(new Dimension(40, 20));
        leftButton.setOpaque(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setBorderPainted(false);
        topBar.add(leftButton, BorderLayout.WEST);

        JLabel logo = new JLabel("CLUBGATE");
        logo.setFont(new Font("Impact", Font.BOLD, 20));
        logo.setForeground(Color.BLACK);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(logo, BorderLayout.CENTER);

        // Notifications button
        JButton notificationsButton = new JButton();
        notificationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Notifications();
            }
        });
        notificationsButton.setPreferredSize(new Dimension(40, 20));
        notificationsButton.setOpaque(false);
        notificationsButton.setContentAreaFilled(false);
        notificationsButton.setBorderPainted(false);
        topBar.add(notificationsButton, BorderLayout.EAST);

        // Club list
        clubListPanel = new JPanel();
        clubListPanel.setLayout(new BoxLayout(clubListPanel, BoxLayout.Y_AXIS));
        clubListPanel.setBounds(20, 40, 360, 480);
        clubListPanel.setOpaque(false);
        add(clubListPanel);

        // Populate club list
        for (Club club : clubs) {
            JPanel clubPanel = new JPanel(new GridLayout(3, 1));
            clubPanel.setPreferredSize(new Dimension(360, 100));
            clubPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            clubPanel.setBackground(Color.WHITE);

            JLabel nameLabel = new JLabel("Name: " + club.getName());
            JLabel typeLabel = new JLabel("Type: " + club.getType());
            JLabel meetingLabel = new JLabel("Meeting: " + club.getMeetingDays() + " at " + club.getMeetingTimes());

            clubPanel.add(nameLabel);
            clubPanel.add(typeLabel);
            clubPanel.add(meetingLabel);

            // Add ActionListener to open ClubPage for this club
            clubPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ClubPage clubPage = new ClubPage(club);
                    clubPage.setVisible(true);
                }
            });

            clubListPanel.add(clubPanel);
        }

        // Scroll pane for club list
        JScrollPane scrollPane = new JScrollPane(clubListPanel);
        scrollPane.setBounds(20, 60, 360, 450);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane);

        // Bottom bar with tab buttons
        JPanel bottomBar = new JPanel();
        bottomBar.setBounds(0, 530, 400, 45);
        bottomBar.setOpaque(false);
        bottomBar.setLayout(new GridLayout(1, 5));
        background.add(bottomBar);

        JButton tab1Button = new JButton();
        tab1Button.setPreferredSize(new Dimension(80, 45));
        tab1Button.setOpaque(false);
        tab1Button.setContentAreaFilled(false);
        tab1Button.setBorderPainted(false);
        bottomBar.add(tab1Button);

        JButton tab2Button = new JButton();
        tab2Button.setPreferredSize(new Dimension(80, 45));
        tab2Button.setOpaque(false);
        tab2Button.setContentAreaFilled(false);
        tab2Button.setBorderPainted(false);
        bottomBar.add(tab2Button);

        JButton tab3Button = new JButton();
        tab3Button.setPreferredSize(new Dimension(80, 45));
        tab3Button.setOpaque(false);
        tab3Button.setContentAreaFilled(false);
        tab3Button.setBorderPainted(false);
        bottomBar.add(tab3Button);

        JButton tab4Button = new JButton();
        tab4Button.setPreferredSize(new Dimension(80, 45));
        tab4Button.setOpaque(false);
        tab4Button.setContentAreaFilled(false);
        tab4Button.setBorderPainted(false);
        bottomBar.add(tab4Button);

        JButton tab5Button = new JButton();
        tab5Button.setPreferredSize(new Dimension(80, 45));
        tab5Button.setOpaque(false);
        tab5Button.setContentAreaFilled(false);
        tab5Button.setBorderPainted(false);
        bottomBar.add(tab5Button);

        // Add action listeners to tab buttons
        tab1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 1
                new HomeScreen();
            }
        });

        tab2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 2
            }
        });

        tab3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CalendarTab();
            }
        });

        tab4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 4
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new MyClubsTab();
                    }
                });
            }
        });

        tab5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add actions for tab button 5
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new InboxTab();
                    }
                });
            }
        });

        setVisible(true);
    }

    private BufferedImage resizeImage(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedResizedImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, null);
            g2d.dispose();
            return bufferedResizedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void addClub(Club club) {
        Club[] newClubs = new Club[clubs.length + 1];
        System.arraycopy(clubs, 0, newClubs, 0, clubs.length);
        newClubs[clubs.length] = club;
        clubs = newClubs;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ClubsTab();
            }
        });
    }
}
