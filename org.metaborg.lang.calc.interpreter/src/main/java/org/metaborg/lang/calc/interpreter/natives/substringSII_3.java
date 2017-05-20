package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.substringSII_3NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({
	@NodeChild(value = "string", type = TermBuild.class),
	@NodeChild(value = "first", type = TermBuild.class),
	@NodeChild(value = "length", type = TermBuild.class)
})
public abstract class substringSII_3 extends TermBuild {

	public substringSII_3(SourceSection source) {
		super(source);
	}

	/**
	 * Return a string composed of the characters of string starting at the
	 * first character (0 being the origin), and composed of length characters
	 * (i.e., up to and including the character first + length - 1).
	 * 
	 * Let size be the size of the string, the following assertions must hold:
	 *   0 <= first
	 *   0 <= length
	 *   first + length <= size
	 * otherwise a runtime failure is raised: 'substring: arguments out of bounds'.
	 * 
	 * @param s
	 * @return
	 */
	@Specialization
	public String doString(String s, int first, int length) {
		String unquoted = s.substring(1, s.length()-1);
		int size = unquoted.length();
		
		if (0 > first || 0 > length || first + length > size) {
			throw new RuntimeException("substring: arguments out of bounds");
		}

		return unquoted.substring(first, first + length);
	}

	public static TermBuild create(SourceSection source, TermBuild string, TermBuild first, TermBuild length) {
		return substringSII_3NodeGen.create(source, string, first, length);
	}
}
