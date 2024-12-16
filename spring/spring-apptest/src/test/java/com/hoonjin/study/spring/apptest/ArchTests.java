package com.hoonjin.study.spring.apptest;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

@AnalyzeClasses(packagesOf = AppTestApplication.class)
public class ArchTests {

    @ArchTest
    ArchRule domainPackageRule = classes().that()
        .resideInAPackage("..domain..")
        .should().onlyBeAccessed().byClassesThat().resideInAnyPackage("..apptest.study..", "..member..", "..domain..");

    @ArchTest
    ArchRule memberPackageRule = noClasses().that()
        .resideInAPackage("..domain")
        .should().accessClassesThat().resideInAPackage("..member..");

    @ArchTest
    ArchRule studyPackageRule = noClasses().that()
        .resideOutsideOfPackage("..apptest.study..")
        .should().accessClassesThat().resideInAPackage("..apptest.study..");

    @ArchTest
    ArchRule freeOfCycles = slices().matching("..apptest.(*)..").should()
        .beFreeOfCycles();
}
