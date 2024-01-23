package com.example.scorpio;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class ScorpioApplication implements ApplicationRunner {

    public static void main(String[] args) {
        // ────────────────────────────────────────────
        // 初期コード
        // ────────────────────────────────────────────
        // SpringApplication.run(ScorpioApplication.class, args);

        // ────────────────────────────────────────────
        // コマンドライン表示用
        // ────────────────────────────────────────────
        // System.out.println("welcome to Spring!!");

        // ────────────────────────────────────────────
        // 実行コマンド
        // ────────────────────────────────────────────
        // cd cd .\build\libs
        // java -jar scorpio-0.0.1-SNAPSHOT.jar --aaa=123 --zzz=456 abc xyz 99

        SpringApplication app = new SpringApplication(ScorpioApplication.class);
        app.setBannerMode(Mode.OFF);
        app.setHeadless(false);
        app.run(args);
    }

    @Override
    public void run(ApplicationArguments args) {
        // ────────────────────────────────────────────
        // ターミナル出力
        // ────────────────────────────────────────────
        // System.out.println("+------------------------------------------+");
        // System.out.println("| this is Application Runner program. |");
        // System.out.println("+------------------------------------------+");
        // System.out.println(args.getOptionNames());
        // System.out.println(args.getNonOptionArgs());
        // System.out.println(Arrays.asList(args.getSourceArgs()));

        JFrame frame = new JFrame("Spring Boot Swing App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new JLabel("Spring Boot Application."));
        frame.setVisible(true);
    }
}
