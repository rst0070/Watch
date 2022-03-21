package publics;

import java.io.Serializable;

public interface DataModel 
extends Serializable
{
	//사용자가 정의하고
	//원격컴퓨터에서 실행되어
	//리턴값을 돌려받는다
	public Object action();


}
