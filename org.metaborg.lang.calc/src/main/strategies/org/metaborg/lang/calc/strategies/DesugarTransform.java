package org.metaborg.lang.calc.strategies;

import org.metaborg.meta.lang.dynsem.interpreter.terms.ITermTransformer;
import org.spoofax.interpreter.terms.IStrategoTerm;
import org.spoofax.jsglr.client.imploder.ImploderOriginTermFactory;
import org.spoofax.terms.TermFactory;
import org.strategoxt.lang.Context;

public final class DesugarTransform implements ITermTransformer {

	@Override
	public IStrategoTerm transform(IStrategoTerm term) {
		Context ctx = new Context(new ImploderOriginTermFactory(new TermFactory()));
		org.metaborg.lang.calc.strategies.Main.init(ctx);
		return org.metaborg.lang.calc.trans.desugar_all_0_0.instance
				.invoke(ctx, term);
	}
} 