package hello.vo;

public class Skill {
	private String skillImg;
	private String skillName;
	private int skillNowLvl;
	private int skillMaxLvl;
	private int skillLvlPoint;
	private String skillDesc;

	public Skill() {

	}

	public Skill(String skillImg, String skillName, int skillNowLvl,
			int skillMaxLvl, int skillLvlPoint, String skillDesc) {
		this.skillImg = skillImg;
		this.skillName = skillName;
		this.skillNowLvl = skillNowLvl;
		this.skillMaxLvl = skillMaxLvl;
		this.skillLvlPoint = skillLvlPoint;
		this.skillDesc = skillDesc;
	}

	public String getSkillImg() {
		return skillImg;
	}

	public void setSkillImg(String skillImg) {
		this.skillImg = skillImg;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillNowLvl() {
		return skillNowLvl;
	}

	public void setSkillNowLvl(int skillNowLvl) {
		this.skillNowLvl = skillNowLvl;
	}

	public int getSkillMaxLvl() {
		return skillMaxLvl;
	}

	public void setSkillMaxLvl(int skillMaxLvl) {
		this.skillMaxLvl = skillMaxLvl;
	}

	public int getSkillLvlPoint() {
		return skillLvlPoint;
	}

	public void setSkillLvlPoint(int skillLvlPoint) {
		this.skillLvlPoint = skillLvlPoint;
	}

	public String getSkillDesc() {
		return skillDesc;
	}

	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}

}
