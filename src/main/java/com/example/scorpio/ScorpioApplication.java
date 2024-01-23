package com.example.scorpio;

// import java.util.Arrays;

// import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import org.springframework.boot.ApplicationArguments;
// import org.springframework.boot.ApplicationRunner;
// import org.springframework.boot.Banner.Mode;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@RestController
public class ScorpioApplication {

    // ────────────────────────────────────────────
    // データ出力用
    // ────────────────────────────────────────────
    // String[][] data = {
    //     {"noname", "no email address", "0"},
    //     {"taro", "taro@yamada", "39"},
    //     {"hanako", "hanako@flower", "28"},
    //     {"sachiko", "sachiko@happy", "17"},
    //     {"jiro", "jiro@change", "6"},
    // };

    // ────────────────────────────────────────────
    // JSON出力用
    // ────────────────────────────────────────────
    DataObject[] data = {
        new DataObject("noname", "no email address", 0),
        new DataObject("taro", "taro@yamada", 39),
        new DataObject("hanako", "hanako@flower", 28),
        new DataObject("sachiko", "sachiko@happy", 17),
    };

    public static void main(String[] args) {
        SpringApplication.run(ScorpioApplication.class, args);

        // ────────────────────────────────────────────
        // コマンドライン表示用
        // ────────────────────────────────────────────
        // System.out.println("welcome to Spring!!");

        // ────────────────────────────────────────────
        // 実行コマンド
        // ────────────────────────────────────────────
        // cd cd .\build\libs
        // java -jar scorpio-0.0.1-SNAPSHOT.jar --aaa=123 --zzz=456 abc xyz 99

        // SpringApplication app = new SpringApplication(ScorpioApplication.class);
        // app.setBannerMode(Mode.OFF);
        // app.setHeadless(false);
        // app.run(args);
    }

    // @Override
    // public void run(ApplicationArguments args) {
    //     // ────────────────────────────────────────────
    //     // ターミナル出力
    //     // ────────────────────────────────────────────
    //     // System.out.println("+------------------------------------------+");
    //     // System.out.println("| this is Application Runner program. |");
    //     // System.out.println("+------------------------------------------+");
    //     // System.out.println(args.getOptionNames());
    //     // System.out.println(args.getNonOptionArgs());
    //     // System.out.println(Arrays.asList(args.getSourceArgs()));

    //     // ────────────────────────────────────────────
    //     // UIアプリ起動
    //     // ────────────────────────────────────────────
    //     JFrame frame = new JFrame("Spring Boot Swing App");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(300, 200);
    //     frame.add(new JLabel("Spring Boot Application."));
    //     frame.setVisible(true);
    // }

    /*
    @RequestMapping("/{num}")
    // ────────────────────────────────────────────
    // データオブジェクト出力用
    // ────────────────────────────────────────────
    public String index(@PathVariable int num) {
        int n = num < 0 ? 0 :num >= data.length ? 0 : num;
        String[] item = data[n];
        String msg = "ID=%s. {name: %s, mail: %s, age:: %s}";
        return String.format(msg, num, item[0], item[1], item[2]);
    }
    */
    /*
    // ────────────────────────────────────────────
    // JSON出力用
    // ────────────────────────────────────────────
    public DataObject index(@PathVariable int num) {
        int n = num < 0 ? 0 :num >= data.length ? 0 : num;
        return data[n];
    }
    */
    @RequestMapping("/")
    public String index(
            jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response) {
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        String content = """
                <html>
                    <head>
                        <title>Sample App</title>
                    </head>
                    <body>
                    <h1>Sample App</h1>
                    <p>This is sample app page;</p>
                </html>
                """;
        return content;
    }
}

/**
 * DataObject
 */
class DataObject {
    private String name;
    private String mail;
    private int age;

    public DataObject(String name, String mail, int age) {
        super();
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}