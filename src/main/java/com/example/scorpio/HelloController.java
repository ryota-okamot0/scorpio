package com.example.scorpio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.Writer;
import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;

@Controller
public class HelloController {
    private boolean flag = false;

    // =============================================================
    // Thymeleaf
    // =============================================================

    // ────────────────────────────────────────────
    // テンプレートHTML表示（パラメータなし）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/{temp}")
    public String index(@PathVariable String temp) {
        switch (temp) {
            case "index":
                return "index";
            default:
                return "other";
        }
    }
*/

    // ────────────────────────────────────────────
    // テンプレートHTML表示（パラメータあり）
    // ────────────────────────────────────────────
/*
    @RequestMapping()
    public String index(Model model) {
        model.addAttribute("msg", "これはコントローラに用意したメッセージです。");
        return "index";
    }
*/

    // ────────────────────────────────────────────
    // テンプレートHTML表示（パラメータModel、他の引数共存）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/{num}")
    public String index(@PathVariable int num, Model model) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        model.addAttribute("msg", "total: " + res);
        return "index";
    }
*/

    // ────────────────────────────────────────────
    // テンプレートHTML表示（ModelAndView）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/{num}")
    public ModelAndView index(@PathVariable int num, ModelAndView mav) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            total += i;
        }
        mav.addObject("msg", num + "までの合計を計算します。");
        mav.addObject("content", "total: " + total);
        mav.setViewName("index");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（テキストフォーム）
    // ────────────────────────────────────────────
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.addObject("msg", "名前を書いてください。");
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView form(@RequestParam("text1") String str, ModelAndView mav) {
        mav.addObject("msg", "こんにちは、 " + str + "さん！");
        mav.addObject("value", str);
        mav.setViewName("index");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（checkbox radio selectフォーム）
    // ────────────────────────────────────────────
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "フォームを送信ください。");
        return mav;
    }

    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView form(
            @RequestParam(value = "check1", required = false)boolean check1,
            @RequestParam(value = "radio1", required = false)String radio1,
            @RequestParam(value = "select1", required = false)String select1,
            @RequestParam(value = "select2", required = false)String[] select2,
            ModelAndView mav) {
        String res = "";
        try {
            res = "check:" + check1 + " radio:" + radio1 + "select:" + select1 + "\nselect2:";
        } catch (NullPointerException e) {}

        try {
            res += select2[0];
            for (int i = 1; i < select2.length; i++) {
                res += ", " + select2[i];
            }
        } catch(NullPointerException e) {
            res += "null";
        }
        mav.addObject("msg", res);
        mav.setViewName("index");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（リダイレクト）
    // ────────────────────────────────────────────
/*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "HelloController/indexのページです。");
        return mav;
    }

    @RequestMapping("/other")
    public String other() {
        return "redirect:/";
    }

    @RequestMapping("/home")
    public String home() {
        return "forward:/";
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（条件分岐）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        flag = !flag;
        mav.setViewName("index");
        mav.addObject("flag", flag);
        mav.addObject("msg", "サンプルのメッセージです。");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（ループ処理）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "データを表示します。");
        String[] data = new String[] {"One", "Two", "Three"};
        mav.addObject("data", data);
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（Switch）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/{month}")
    public ModelAndView index(@PathVariable int month, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", month + "月は？");
        mav.addObject("month", month);
        return mav;
    }
*/

    // =============================================================
    // Mustache
    // =============================================================

    // ────────────────────────────────────────────
    // テンプレートHTML表示（パラメータ渡し）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("msg", "メッセージだよ。");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（htmlタグ表示）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        String msg = """
                <div class="border border-primary">
                    <h2>Message</h2>
                    <p>This is sample message!</p>
                </div>
                """;
        mav.addObject("msg", msg);
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（条件分岐）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        flag = !flag;
        mav.addObject("flag", flag);
        mav.addObject("msg", "メッセージを表示します。");
        return mav;
    }
*/
    // ────────────────────────────────────────────
    // テンプレートHTML表示（ループ処理）
    // ────────────────────────────────────────────
/*
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        MyData[] data = new MyData[] {
            new MyData("Taro", 39),
            new MyData("Hanako", 28),
            new MyData("Sachiko", 17),
        };
        mav.addObject("data", data);
        return mav;
    }
*/

    // ────────────────────────────────────────────
    // ラムダ式
    // ────────────────────────────────────────────
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("title", "ラムダ式のサンプル");
        mav.addObject("msg", "これはラムダ式を利用してメッセージを表示したものです。");

        Lambda fn = new Lambda() {
            public void execute (Fragment frag, Writer out) throws IOException {
                out.write("<div class=\"alert alert-primary\">");
                frag.execute(out);
                out.write("</div>");
            }
        };
        mav.addObject("fn", fn);
        return mav;
    }
}
/**
 * MyData
 */
class MyData {
    public String name;
    public int age;

    public MyData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return String.format("{Name: %s, age: %d}", name, age);
    }
}