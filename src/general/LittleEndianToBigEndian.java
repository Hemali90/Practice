package general;
public class LittleEndianToBigEndian {
//swap 3rd byte with 0
//swap 2nd with 1.
public void convert(int a){
	a=(((a >> 24) & 0xff) |
	(((a >> 16) & 0xff) << 8) |
	(((a >> 8) & 0xff) << 16) |
	((a & 0xff) << 8));
}
}
