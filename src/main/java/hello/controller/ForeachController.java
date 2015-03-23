package hello.controller;

import hello.vo.Skill;

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
		List<Skill> test = readTxtFile(type);
	
		model.addAttribute("skillList", test);
		model.addAttribute("passiveList", readPassive());
		return "fortest";
	}

	public List<Skill> readPassive() {
		List<Skill> passive = readTxtFile("passive");

		return passive;
	}

	public List<Skill> readTxtFile(String filename) {
		List<Skill> output = new ArrayList<Skill>();

		Resource resource = new ClassPathResource("/data/" + filename + ".txt");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					resource.getInputStream()), 1024);
			String line;

			while ((line = br.readLine()) != null) {
				Skill skillData = new Skill();
				StringTokenizer str = new StringTokenizer(line, "|");

				if (str.countTokens() > 1) {
					skillData.setSkillImg(str.nextToken());
					skillData.setSkillName(str.nextToken());
					skillData.setSkillNowLvl(0);
					skillData.setSkillMaxLvl(Integer.parseInt(str.nextToken()));
					skillData
							.setSkillLvlPoint(Integer.parseInt(str.nextToken()));
					skillData.setSkillDesc(str.nextToken());
					output.add(skillData);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}
