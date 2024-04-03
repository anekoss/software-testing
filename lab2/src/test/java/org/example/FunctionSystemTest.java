package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class FunctionSystemTest {
    private static final double PRECISION = 0.01;
    static LnFunction lnMock = Mockito.mock(LnFunction.class);
    static LogFunction logMock = Mockito.mock(LogFunction.class);
    static SinFunction sinMock = Mockito.mock(SinFunction.class);
    static TrigonometricFunction trigonometricMock = Mockito.mock(TrigonometricFunction.class);

    static {
        when(lnMock.calculate(2)).thenReturn(0.693147);
        when(lnMock.calculate(3)).thenReturn(1.09861);
        when(lnMock.calculate(5)).thenReturn(1.60944);
        when(lnMock.calculate(10)).thenReturn(2.30259);

        when(lnMock.calculate(1)).thenReturn(0d);
        when(lnMock.calculate(1.6)).thenReturn(0.47000362925);
        when(lnMock.calculate(5)).thenReturn(1.60943791243);
        when(lnMock.calculate(12)).thenReturn(2.48490664979);
        when(lnMock.calculate(20)).thenReturn(2.99573227355);
        when(lnMock.calculate(150)).thenReturn(5.01063529410);
        when(lnMock.calculate(0.6)).thenReturn(-0.51082562376);
        when(lnMock.calculate(0.3)).thenReturn(-1.20397280433);
        when(lnMock.calculate(0.15)).thenReturn(-1.89711998488);
        when(lnMock.calculate(0.02)).thenReturn(-3.91202300543);
    }

    static {
        when(logMock.ln(1.0)).thenReturn(0d);
        when(logMock.ln(1.6)).thenReturn(0.47000362925);
        when(logMock.ln(5)).thenReturn(1.60943791243);
        when(logMock.ln(12)).thenReturn(2.48490664979);
        when(logMock.ln(20)).thenReturn(2.99573227355);
        when(logMock.ln(150)).thenReturn(5.01063529410);
        when(logMock.ln(0.6)).thenReturn(-0.51082562376);
        when(logMock.ln(0.3)).thenReturn(-1.20397280433);
        when(logMock.ln(0.15)).thenReturn(-1.89711998488);
        when(logMock.ln(0.02)).thenReturn(-3.91202300543);


        when(logMock.log(1, 10)).thenReturn(0d);
        when(logMock.log(1.6, 10)).thenReturn(0.2041199826559248);
        when(logMock.log(5, 10)).thenReturn(0.6989700043360189);
        when(logMock.log(12, 10)).thenReturn(1.0791812460476249);
        when(logMock.log(20, 10)).thenReturn(1.3010299956639813);
        when(logMock.log(150, 10)).thenReturn(2.1760912590556813);
        when(logMock.log(0.6, 10)).thenReturn(-0.2218487496163564);
        when(logMock.log(0.3, 10)).thenReturn(-0.5228787452803376);
        when(logMock.log(0.15, 10)).thenReturn(-0.8239087409443188);
        when(logMock.log(0.02, 10)).thenReturn(-1.6989700043360187);

        when(logMock.log(1, 2)).thenReturn(0d);
        when(logMock.log(1.6, 2)).thenReturn(0.678);
        when(logMock.log(5, 2)).thenReturn(2.3219);
        when(logMock.log(12, 2)).thenReturn(3.58496);
        when(logMock.log(20, 2)).thenReturn(4.32193);
        when(logMock.log(150, 2)).thenReturn(7.22882);
        when(logMock.log(0.6, 2)).thenReturn(-0.737);
        when(logMock.log(0.3, 2)).thenReturn(-1.7364);
        when(logMock.log(0.15, 2)).thenReturn(-2.7369);
        when(logMock.log(0.02, 2)).thenReturn(-5.64386);

        when(logMock.log(1, 5)).thenReturn(0d);
        when(logMock.log(1.6, 5)).thenReturn(0.2920296742201792);
        when(logMock.log(5, 5)).thenReturn(1d);
        when(logMock.log(12, 5)).thenReturn(1.5439593106327716);
        when(logMock.log(20, 5)).thenReturn(1.8613531161467862);
        when(logMock.log(150, 5)).thenReturn(3.1132827525593783);
        when(logMock.log(0.6, 5)).thenReturn(-0.31739380551401475);
        when(logMock.log(0.3, 5)).thenReturn(-0.7480703635874079);
        when(logMock.log(0.15, 5)).thenReturn(-1.1787469216608009);
        when(logMock.log(0.02, 5)).thenReturn(-2.4306765580733933);

        when(logMock.log(1, 3)).thenReturn(0d);
        when(logMock.log(1.6, 3)).thenReturn(0.4278157399964452);
        when(logMock.log(5, 3)).thenReturn(1.4649735207179269);
        when(logMock.log(12, 3)).thenReturn(2.2618595071429146);
        when(logMock.log(20, 3)).thenReturn(2.7268330278608417);
        when(logMock.log(150, 3)).thenReturn(4.560876795007311);
        when(logMock.log(0.6, 3)).thenReturn(-0.4649735207179272);
        when(logMock.log(0.3, 3)).thenReturn(-1.0959032742893846);
        when(logMock.log(0.15, 3)).thenReturn(-1.726833027860842);
        when(logMock.log(0.02, 3)).thenReturn(-3.5608767950073115);
    }

    static {
        when(sinMock.calculate(-2.1278)).thenReturn(-0.8488429);
        when(sinMock.calculate(-2.0000)).thenReturn(-0.9092974);
        when(sinMock.calculate(-2.0500)).thenReturn(-0.8873624);
        when(sinMock.calculate(-2.1700)).thenReturn(-0.8257850);
        when(sinMock.calculate(-2.1790)).thenReturn(-0.8206758);
        when(sinMock.calculate(-1.7510)).thenReturn(-0.9838072);
        when(sinMock.calculate(-2.2220)).thenReturn(-0.7953548);
        when(sinMock.calculate(-2.2300)).thenReturn(-0.7904802);
        when(sinMock.calculate(-2.2400)).thenReturn(-0.7843159);
        when(sinMock.calculate(-2.2468)).thenReturn(-0.7800794);
        when(sinMock.calculate(-2.2358)).thenReturn(-0.7869145);
        when(sinMock.calculate(-1.2247)).thenReturn(-0.9407041);
        when(sinMock.calculate(-1.2165)).thenReturn(-0.9378908);
        when(sinMock.calculate(-1.2336)).thenReturn(-0.9436859);
        when(sinMock.calculate(-4.0980)).thenReturn(0.8171258);
        when(sinMock.calculate(-4.1330)).thenReturn(0.8367973);
        when(sinMock.calculate(-4.1800)).thenReturn(0.8615969);
        when(sinMock.calculate(-4.1120)).thenReturn(0.8251159);
        when(sinMock.calculate(-5.1820)).thenReturn(0.8917444);
        when(sinMock.calculate(-5.0480)).thenReturn(0.9442092);
        when(sinMock.calculate(-5.3450)).thenReturn(0.8064865);
        when(sinMock.calculate(-2.236)).thenReturn(-0.7867910903962507);


        when(sinMock.calculate(-2.1278 + Math.PI / 2)).thenReturn(-0.5286452);
        when(sinMock.calculate(-2.0000+ Math.PI / 2)).thenReturn(-0.4161468);
        when(sinMock.calculate(-2.0500 + Math.PI / 2)).thenReturn(-0.4610726913767128);
        when(sinMock.calculate(-2.1700+ Math.PI / 2)).thenReturn(-0.5639851);
        when(sinMock.calculate(-2.1790 + Math.PI / 2)).thenReturn(-0.5713941809342375);
        when(sinMock.calculate(-1.7510 + Math.PI / 2)).thenReturn(-0.1792300);
        when(sinMock.calculate(-2.2220 + Math.PI / 2)).thenReturn(-0.6061442);
        when(sinMock.calculate(-2.2300 + Math.PI / 2)).thenReturn(-0.6124876);
        when(sinMock.calculate(-2.2400 + Math.PI / 2)).thenReturn(-0.6203616);
        when(sinMock.calculate(-2.2468 + Math.PI / 2)).thenReturn(-0.6256806);
        when(sinMock.calculate(-2.2358 + Math.PI / 2)).thenReturn(-0.6172193937920931);
        when(sinMock.calculate(-1.2247 + Math.PI / 2)).thenReturn(0.3392282);
        when(sinMock.calculate(-1.2165 + Math.PI / 2)).thenReturn(0.3469305);
        when(sinMock.calculate(-1.2336 + Math.PI / 2)).thenReturn(0.3308426);
        when(sinMock.calculate(-4.0980 + Math.PI / 2)).thenReturn(-0.5764594);
        when(sinMock.calculate(-4.1330 + Math.PI / 2)).thenReturn(-0.5475127);
        when(sinMock.calculate(-4.1800 + Math.PI / 2)).thenReturn(-0.5075931);
        when(sinMock.calculate(-4.1120 + Math.PI / 2)).thenReturn(-0.5649635);
        when(sinMock.calculate(-5.1820 + Math.PI / 2)).thenReturn(0.4525394);
        when(sinMock.calculate(-5.0480 + Math.PI / 2)).thenReturn(0.3293462);
        when(sinMock.calculate(-5.3450 + Math.PI / 2)).thenReturn(0.5912525);
        when(sinMock.calculate(-2.236 + Math.PI / 2)).thenReturn(-0.6172193937920931);
    }

    static {
        when(trigonometricMock.sin(-2.1278)).thenReturn(-0.8488429);
        when(trigonometricMock.sin(-2.0000)).thenReturn(-0.9092974);
        when(trigonometricMock.sin(-2.0500)).thenReturn(-0.8873624);
        when(trigonometricMock.sin(-2.1700)).thenReturn(-0.8257850);
        when(trigonometricMock.sin(-2.1790)).thenReturn(-0.8206758);
        when(trigonometricMock.sin(-1.7510)).thenReturn(-0.9838072);
        when(trigonometricMock.sin(-2.2220)).thenReturn(-0.7953548);
        when(trigonometricMock.sin(-2.2300)).thenReturn(-0.7904802);
        when(trigonometricMock.sin(-2.2400)).thenReturn(-0.7843159);
        when(trigonometricMock.sin(-2.2468)).thenReturn(-0.7800794);
        when(trigonometricMock.sin(-2.2358)).thenReturn(-0.7869145);
        when(trigonometricMock.sin(-1.2247)).thenReturn(-0.9407041);
        when(trigonometricMock.sin(-1.2165)).thenReturn(-0.9378908);
        when(trigonometricMock.sin(-1.2336)).thenReturn(-0.9436859);
        when(trigonometricMock.sin(-4.0980)).thenReturn(0.8171258);
        when(trigonometricMock.sin(-4.1330)).thenReturn(0.8367973);
        when(trigonometricMock.sin(-4.1800)).thenReturn(0.8615969);
        when(trigonometricMock.sin(-4.1120)).thenReturn(0.8251159);
        when(trigonometricMock.sin(-5.1820)).thenReturn(0.8917444);
        when(trigonometricMock.sin(-5.0480)).thenReturn(0.9442092);
        when(trigonometricMock.sin(-5.3450)).thenReturn(0.8064865);
        when(trigonometricMock.sin(-2.2360)).thenReturn(-0.7867911);


        when(trigonometricMock.cos(-2.1278)).thenReturn(-0.5286452);
        when(trigonometricMock.cos(-2.0000)).thenReturn(-0.4161468);
        when(trigonometricMock.cos(-2.0500)).thenReturn(-0.4610727);
        when(trigonometricMock.cos(-2.1700)).thenReturn(-0.5639851);
        when(trigonometricMock.cos(-2.1790)).thenReturn(-0.5713942);
        when(trigonometricMock.cos(-1.7510)).thenReturn(-0.1792300);
        when(trigonometricMock.cos(-2.2220)).thenReturn(-0.6061442);
        when(trigonometricMock.cos(-2.2300)).thenReturn(-0.6124876);
        when(trigonometricMock.cos(-2.2400)).thenReturn(-0.6203616);
        when(trigonometricMock.cos(-2.2468)).thenReturn(-0.6256806);
        when(trigonometricMock.cos(-2.2358)).thenReturn(-0.6170620);
        when(trigonometricMock.cos(-1.2247)).thenReturn(0.3392282);
        when(trigonometricMock.cos(-1.2165)).thenReturn(0.3469305);
        when(trigonometricMock.cos(-1.2336)).thenReturn(0.3308426);
        when(trigonometricMock.cos(-4.0980)).thenReturn(-0.5764594);
        when(trigonometricMock.cos(-4.1330)).thenReturn(-0.5475127);
        when(trigonometricMock.cos(-4.1800)).thenReturn(-0.5075931);
        when(trigonometricMock.cos(-4.1120)).thenReturn(-0.5649635);
        when(trigonometricMock.cos(-5.1820)).thenReturn(0.4525394);
        when(trigonometricMock.cos(-5.0480)).thenReturn(0.3293462);
        when(trigonometricMock.cos(-5.3450)).thenReturn(0.5912525);
        when(trigonometricMock.cos(-2.2360)).thenReturn(-0.6172194);

        when(trigonometricMock.tan(-2.1278)).thenReturn(1.6056950);
        when(trigonometricMock.tan(-2.0000)).thenReturn(2.1850399);
        when(trigonometricMock.tan(-2.0500)).thenReturn(1.9245607);
        when(trigonometricMock.tan(-2.1700)).thenReturn(1.4641966);
        when(trigonometricMock.tan(-2.1790)).thenReturn(1.4362690);
        when(trigonometricMock.tan(-1.7510)).thenReturn(5.4890781);
        when(trigonometricMock.tan(-2.2220)).thenReturn(1.3121544);
        when(trigonometricMock.tan(-2.2300)).thenReturn(1.2906062);
        when(trigonometricMock.tan(-2.2400)).thenReturn(1.2642883);
        when(trigonometricMock.tan(-2.2468)).thenReturn(1.2467693);
        when(trigonometricMock.tan(-2.2358)).thenReturn(1.2752600);
        when(trigonometricMock.tan(-1.2247)).thenReturn(-2.7730717);
        when(trigonometricMock.tan(-1.2165)).thenReturn(-2.7033971);
        when(trigonometricMock.tan(-1.2336)).thenReturn(-2.8523713);
        when(trigonometricMock.tan(-4.0980)).thenReturn(-1.4174908);
        when(trigonometricMock.tan(-4.1330)).thenReturn(-1.5283614);
        when(trigonometricMock.tan(-4.1800)).thenReturn(-1.6974164);
        when(trigonometricMock.tan(-4.1120)).thenReturn(-1.4604766);
        when(trigonometricMock.tan(-5.1820)).thenReturn(1.9705340);
        when(trigonometricMock.tan(-5.0480)).thenReturn(2.8669205);
        when(trigonometricMock.tan(-5.3450)).thenReturn(1.3640305);
        when(trigonometricMock.tan(-2.2360)).thenReturn(1.2747349);

        when(trigonometricMock.cot(-2.1278)).thenReturn(0.6227833);
        when(trigonometricMock.cot(-2.0000)).thenReturn(0.4576576);
        when(trigonometricMock.cot(-2.0500)).thenReturn(0.5195991);
        when(trigonometricMock.cot(-2.1700)).thenReturn(0.6829684);
        when(trigonometricMock.cot(-2.1790)).thenReturn(0.6962484);
        when(trigonometricMock.cot(-1.7510)).thenReturn(0.1821800);
        when(trigonometricMock.cot(-2.2220)).thenReturn(0.7621054);
        when(trigonometricMock.cot(-2.2300)).thenReturn(0.7748297);
        when(trigonometricMock.cot(-2.2400)).thenReturn(0.7909588);
        when(trigonometricMock.cot(-2.2468)).thenReturn(0.8020730);
        when(trigonometricMock.cot(-2.2358)).thenReturn(0.7841538);
        when(trigonometricMock.cot(-1.2247)).thenReturn(-0.3606109);
        when(trigonometricMock.cot(-1.2165)).thenReturn(-0.3699050);
        when(trigonometricMock.cot(-1.2336)).thenReturn(-0.3505855);
        when(trigonometricMock.cot(-4.0980)).thenReturn(-0.7054719);
        when(trigonometricMock.cot(-4.1330)).thenReturn(-0.6542955);
        when(trigonometricMock.cot(-4.1800)).thenReturn(-0.5891306);
        when(trigonometricMock.cot(-4.1120)).thenReturn(-0.6847080);
        when(trigonometricMock.cot(-5.1820)).thenReturn(0.5074766);
        when(trigonometricMock.cot(-5.0480)).thenReturn(0.3488063);
        when(trigonometricMock.cot(-5.3450)).thenReturn(0.7331214);
        when(trigonometricMock.cot(-2.2360)).thenReturn(0.7844768);

        when(trigonometricMock.csc(-2.1278)).thenReturn(-1.1780743);
        when(trigonometricMock.csc(-2.0000)).thenReturn(-1.0997502);
        when(trigonometricMock.csc(-2.0500)).thenReturn(-1.1269353);
        when(trigonometricMock.csc(-2.1700)).thenReturn(-1.2109690);
        when(trigonometricMock.csc(-2.1790)).thenReturn(-1.2185080);
        when(trigonometricMock.csc(-1.7510)).thenReturn(-1.0164593);
        when(trigonometricMock.csc(-2.2220)).thenReturn(-1.2573006);
        when(trigonometricMock.csc(-2.2300)).thenReturn(-1.2650538);
        when(trigonometricMock.csc(-2.2400)).thenReturn(-1.2749964);
        when(trigonometricMock.csc(-2.2468)).thenReturn(-1.2819208);
        when(trigonometricMock.csc(-2.2358)).thenReturn(-1.2707861);
        when(trigonometricMock.csc(-1.2247)).thenReturn(-1.0630335);
        when(trigonometricMock.csc(-1.2165)).thenReturn(-1.0662222);
        when(trigonometricMock.csc(-1.2336)).thenReturn(-1.0596746);
        when(trigonometricMock.csc(-4.0980)).thenReturn(1.2238017);
        when(trigonometricMock.csc(-4.1330)).thenReturn(1.1950325);
        when(trigonometricMock.csc(-4.1800)).thenReturn(1.1606356);
        when(trigonometricMock.csc(-4.1120)).thenReturn(1.2119509);
        when(trigonometricMock.csc(-5.1820)).thenReturn(1.1213976);
        when(trigonometricMock.csc(-5.0480)).thenReturn(1.0590873);
        when(trigonometricMock.csc(-5.3450)).thenReturn(1.2399464);
        when(trigonometricMock.csc(-2.236)).thenReturn(-1.2709854);


        when(trigonometricMock.sec(-2.1278)).thenReturn(-1.8916280);
        when(trigonometricMock.sec(-2.0000)).thenReturn(-2.4029980);
        when(trigonometricMock.sec(-2.0500)).thenReturn(-2.1688554);
        when(trigonometricMock.sec(-2.1700)).thenReturn(-1.7730966);
        when(trigonometricMock.sec(-2.1790)).thenReturn(-1.7501053);
        when(trigonometricMock.sec(-1.7510)).thenReturn(-5.5794246);
        when(trigonometricMock.sec(-2.2220)).thenReturn(-1.6497725);
        when(trigonometricMock.sec(-2.2300)).thenReturn(-1.6326862);
        when(trigonometricMock.sec(-2.2400)).thenReturn(-1.6119631);
        when(trigonometricMock.sec(-2.2468)).thenReturn(-1.5982596);
        when(trigonometricMock.sec(-2.2358)).thenReturn(-1.6205826);
        when(trigonometricMock.sec(-1.2247)).thenReturn(2.9478681);
        when(trigonometricMock.sec(-1.2165)).thenReturn(2.8824218);
        when(trigonometricMock.sec(-1.2336)).thenReturn(3.0225853);
        when(trigonometricMock.sec(-4.0980)).thenReturn(-1.7347277);
        when(trigonometricMock.sec(-4.1330)).thenReturn(-1.8264415);
        when(trigonometricMock.sec(-4.1800)).thenReturn(-1.9700818);
        when(trigonometricMock.sec(-4.1120)).thenReturn(-1.7700259);
        when(trigonometricMock.sec(-5.1820)).thenReturn(2.2097521);
        when(trigonometricMock.sec(-5.0480)).thenReturn(3.0363190);
        when(trigonometricMock.sec(-5.3450)).thenReturn(1.6913247);
        when(trigonometricMock.sec(-2.2360)).thenReturn(-1.6201694);
    }

    private static Stream<Arguments> testValues() {
        return Stream.of(
                Arguments.of(1, NaN),
                Arguments.of(1.6, -1.669),
                Arguments.of(5, -0.661),
                Arguments.of(12, 7.795),
                Arguments.of(0.6, 1.559),
                Arguments.of(0.3, 2.237),
                Arguments.of(0.15, 23.516),
                Arguments.of(-2.1278, -1.583),
                Arguments.of(-2, -0.756),
                Arguments.of(-2.05, -1.115),
                Arguments.of(-2.17, -1.804),
                Arguments.of(-2.179, -1.848),
                Arguments.of(-1.751, 3.067),
                Arguments.of(-2.236, -2.114),
                Arguments.of(-2.222, -2.051),
                Arguments.of(-2.23, -2.087),
                Arguments.of(-2.24, -2.131),
                Arguments.of(-2.2468, -2.161),
                Arguments.of(-2.2358, -2.113),
                Arguments.of(-1.2247, -3.762),
                Arguments.of(-1.2165, -3.664),
                Arguments.of(-1.2336, -3.872),
                Arguments.of(-4.098, -4.2799),
                Arguments.of(-4.133, -4.469),
                Arguments.of(-4.18, -4.788),
                Arguments.of(-4.112, -4.351),
                Arguments.of(-5.182, 8.932),
                Arguments.of(-5.048, 11.353),
                Arguments.of(-5.345, 7.421)
        );
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void testWithLnAndSinMocks(double x, double expected) {
        LogFunction logFunction = new LogFunction(lnMock);
        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(sinMock);
        FunctionSystem functionSystem = new FunctionSystem(logFunction, trigonometricFunction);
        assertEquals(expected, functionSystem.calculate(x), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void testWithLogMock(double x, double expected) {
        TrigonometricFunction trigonometricFunction = new TrigonometricFunction(sinMock);
        FunctionSystem functionSystem = new FunctionSystem(logMock, trigonometricFunction);
        assertEquals(expected, functionSystem.calculate(x), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void testWithTrigonometricMock(double x, double expected) {
        LogFunction logFunction = new LogFunction(lnMock);
        FunctionSystem functionSystem = new FunctionSystem(logFunction, trigonometricMock);
        assertEquals(expected, functionSystem.calculate(x), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void testWithLogAndTrigonometricMocks(double x, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(logMock, trigonometricMock);
        assertEquals(expected, functionSystem.calculate(x), PRECISION);
    }

    @ParameterizedTest
    @MethodSource("testValues")
    public void testFunction(double x, double expected) {
        FunctionSystem functionSystem = new FunctionSystem(new LogFunction(new LnFunction()), new TrigonometricFunction(new SinFunction()));
        assertEquals(expected, functionSystem.calculate(x), PRECISION);
    }

}
