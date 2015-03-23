package hello.controller;

import hello.Body;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForeachController {

	@RequestMapping("/fortest")
	public String fortest(
			@RequestParam(value = "type", required = true) String type,
			Model model) {
		List<Body> test = readTxtFile(type);

		for (Body temp : readPassive()) {
			System.out.println(temp.getTest1());
			System.out.println(temp.getTest2());
			System.out.println(temp.getTest3());
		}

		model.addAttribute("testList", test);
		model.addAttribute("passive", readPassive());
		return "fortest";
	}

	public List<Body> readPassive() {
		List<Body> passive = readTxtFile("passive");

		return passive;
	}

	public List<Body> readTxtFile(String filename) {
		List<Body> output = new ArrayList<Body>();

		Resource resource = new ClassPathResource("/data/" + filename + ".txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					resource.getInputStream()), 1024);
			String line;

			while ((line = br.readLine()) != null) {
				Body temp = new Body();
				StringTokenizer str = new StringTokenizer(line, "|");

				if (str.countTokens() > 1) {
					temp.setTest1(str.nextToken());
					temp.setTest2(str.nextToken());
					temp.setTest3(str.nextToken());
					output.add(temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return output;
	}
}
