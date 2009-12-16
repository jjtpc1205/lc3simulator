package nju.edu.lc3.simluator.instruction;

import nju.edu.lc3.util.BitUtil;

public class Bit_Fill extends BitInstruction{

	public Bit_Fill(char[] bit)
	{
		this.bit = bit;
	}
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return ".FILL "+BitUtil.bitarrayToInt(bit, 0, 16, true);
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

}
