package com.java_2_base.webapp.other;

import com.java_2_base.webapp.model.*;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = ResumeTestData.createResume_4("test", "Григорий Кислин");
        System.out.println(resume.toString());
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, "телефон");

        SimpleTextSection sectionPersonal = new SimpleTextSection("Личное");
        resume.setSection(SectionType.PERSONAL, sectionPersonal);

        return resume;
    }

    public static Resume createResume_2(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, "телефон");
        resume.setContact(ContactType.SKYPE, "скайп");

        SimpleTextSection sectionPersonal = new SimpleTextSection("Личное");
        resume.setSection(SectionType.PERSONAL, sectionPersonal);

        SimpleTextSection sectionObjective = new SimpleTextSection("Позиция");
        resume.setSection(SectionType.OBJECTIVE, sectionObjective);

        List<String> achievements = Arrays.asList(
                "Достижение 1",
                "Достижение 2"
        );
        ListSection sectionAchievements = new ListSection(achievements);
        resume.setSection(SectionType.ACHIEVEMENT, sectionAchievements);

        List<String> qualifications = Arrays.asList(
                "Квалификация 1",
                "Квалификация 2"
        );
        ListSection sectionQualifications = new ListSection(qualifications);
        resume.setSection(SectionType.QUALIFICATIONS, sectionQualifications);

        return resume;
    }

    public static Resume createResume_3(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, "телефон");
        resume.setContact(ContactType.SKYPE, "скайп");

        SimpleTextSection sectionPersonal = new SimpleTextSection("Личное");
        resume.setSection(SectionType.PERSONAL, sectionPersonal);

        SimpleTextSection sectionObjective = new SimpleTextSection("Позиция");
        resume.setSection(SectionType.OBJECTIVE, sectionObjective);

        List<String> achievements = Arrays.asList(
                "Достижение 1",
                "Достижение 2"
        );
        ListSection sectionAchievements = new ListSection(achievements);
        resume.setSection(SectionType.ACHIEVEMENT, sectionAchievements);

        List<String> qualifications = Arrays.asList(
                "Квалификация 1",
                "Квалификация 2"
        );
        ListSection sectionQualifications = new ListSection(qualifications);
        resume.setSection(SectionType.QUALIFICATIONS, sectionQualifications);

        List<Organization> organization = Arrays.asList(
                new Organization("Компания 1", "сайт 1",
                        new Organization.Position(1997, Month.SEPTEMBER, 2005, Month.JANUARY,
                                "Должность 1",
                                "Описание 1"
                        )
                ),
                new Organization("Компания 2", "сайт 2",
                        new Organization.Position(2005, Month.JANUARY, 2007, Month.FEBRUARY,
                                "Должность 2",
                                null
                        )
                )
        );
        OrganizationSection sectionExperience = new OrganizationSection(organization);
        resume.setSection(SectionType.EXPERIENCE, sectionExperience);

        List<Organization> education = Arrays.asList(
                new Organization("Школа 1", null,
                        new Organization.Position(1984, Month.SEPTEMBER, 1987, Month.JUNE, "Описание 2-1")
                ),
                new Organization("Школа 2", "сайт 2",
                        new Organization.Position(1987, Month.SEPTEMBER, 1993, Month.JULY, "Описание 2-1"),
                        new Organization.Position(1993, Month.SEPTEMBER, 1996, Month.JULY, "Описание 2-2")
                )
        );
        OrganizationSection sectionEducation = new OrganizationSection(education);
        resume.setSection(SectionType.EDUCATION, sectionEducation);

        return resume;
    }

    public static Resume createResume_4(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);

        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.SKYPE, "grigory.kislin");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin/");
        resume.setContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.setContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.setContact(ContactType.HOMEPAGE, "http://gkislin.ru/");

        SimpleTextSection sectionPersonal = new SimpleTextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.setSection(SectionType.PERSONAL, sectionPersonal);

        SimpleTextSection sectionObjective = new SimpleTextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        resume.setSection(SectionType.OBJECTIVE, sectionObjective);

        List<String> achievements = Arrays.asList(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        );
        ListSection sectionAchievements = new ListSection(achievements);
        resume.setSection(SectionType.ACHIEVEMENT, sectionAchievements);

        List<String> qualifications = Arrays.asList(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\""
        );
        ListSection sectionQualifications = new ListSection(qualifications);
        resume.setSection(SectionType.QUALIFICATIONS, sectionQualifications);

        List<Organization> organization = Arrays.asList(
                new Organization("Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(1997, Month.SEPTEMBER, 2005, Month.JANUARY,
                                "Инженер по аппаратному и программному тестированию",
                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."
                        )
                ),
                new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html",
                        new Organization.Position(2005, Month.JANUARY, 2007, Month.FEBRUARY,
                                "Разработчик ПО",
                                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."
                        )
                ),
                new Organization("Enkata", "https://www.pega.com/products/robotic-process-automation",
                        new Organization.Position(2007, Month.MARCH, 2008, Month.JUNE,
                                "Разработчик ПО",
                                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."
                        )
                ),
                new Organization("Yota", "https://www.yota.ru/",
                        new Organization.Position(2008, Month.JUNE, 2010, Month.DECEMBER,
                                "Ведущий специалист",
                                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"
                        )
                ),
                new Organization("Luxoft (Deutsche Bank)", "https://www.luxoft.com/",
                        new Organization.Position(2010, Month.DECEMBER, 2012, Month.APRIL,
                                "Ведущий программист",
                                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."
                        )
                ),
                new Organization("RIT Center", "",
                        new Organization.Position(2012, Month.APRIL, 2014, Month.OCTOBER,
                                "Java архитектор",
                                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"
                        )
                ),
                new Organization("Wrike", "https://www.wrike.com/",
                        new Organization.Position(2014, Month.OCTOBER, 2016, Month.JANUARY,
                                "Старший разработчик (backend)",
                                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."
                        )
                ),
                new Organization("Java Online Projects", "https://javaops.ru/",
                        new Organization.Position(2013, Month.OCTOBER,
                                "Автор проекта",
                                "Создание, организация и проведение Java онлайн проектов и стажировок."
                        )
                )
        );
        OrganizationSection sectionExperience = new OrganizationSection(organization);
        resume.setSection(SectionType.EXPERIENCE, sectionExperience);

        List<Organization> education = Arrays.asList(
                new Organization("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                        new Organization.Position(1984, Month.SEPTEMBER, 1987, Month.JUNE, "Закончил с отличием")
                ),
                new Organization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики", "https://itmo.ru/ru/",
                        new Organization.Position(1987, Month.SEPTEMBER, 1993, Month.JULY, "Инженер (программист Fortran, C)"),
                        new Organization.Position(1993, Month.SEPTEMBER, 1996, Month.JULY, "Аспирантура (программист С, С++)")
                ),
                new Organization("Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(1997, Month.SEPTEMBER, 1998, Month.MARCH, "6 месяцев обучения цифровым телефонным сетям (Москва)")
                ),
                new Organization("Siemens AG", "https://new.siemens.com/ru/ru.html",
                        new Organization.Position(2005, Month.JANUARY, 2005, Month.MARCH, "3 месяца обучения мобильным IN сетям (Берлин)")
                ),
                new Organization("Luxoft", "https://www.luxoft-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html",
                        new Organization.Position(2011, Month.MARCH, 2011, Month.APRIL, "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"")
                ),
                new Organization("Coursera", "https://www.coursera.org/learn/progfun1",
                        new Organization.Position(2013, Month.MARCH, 2013, Month.MAY, "\"Functional Programming Principles in Scala\" by Martin Odersky")
                )
        );
        OrganizationSection sectionEducation = new OrganizationSection(education);
        resume.setSection(SectionType.EDUCATION, sectionEducation);

        return resume;
    }
}
