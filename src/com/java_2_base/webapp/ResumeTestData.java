package com.java_2_base.webapp;

import com.java_2_base.webapp.model.ContactType;
import com.java_2_base.webapp.model.Resume;
import com.java_2_base.webapp.model.SectionType;

import java.time.LocalDate;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");

        resume.addContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.addContact(ContactType.SKYPE, "grigory.kislin");
        resume.addContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.addContact(ContactType.LINKEDIN, "https://www.linkedin.com/in/gkislin/");
        resume.addContact(ContactType.GITHUB, "https://github.com/gkislin");
        resume.addContact(ContactType.STACKOVERFLOW, "https://stackoverflow.com/users/548473/grigory-kislin");
        resume.addContact(ContactType.HOMEPAGE, "http://gkislin.ru/");

        resume.addSectionString(SectionType.PERSONAL, "Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
        resume.addSectionString(SectionType.OBJECTIVE, "Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");

        resume.addSectionListString(SectionType.ACHIEVEMENT, "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        resume.addSectionListString(SectionType.ACHIEVEMENT, "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        resume.addSectionListString(SectionType.ACHIEVEMENT, "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        resume.addSectionListString(SectionType.ACHIEVEMENT, "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        resume.addSectionListString(SectionType.ACHIEVEMENT, "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        resume.addSectionListString(SectionType.ACHIEVEMENT, "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");

        resume.addSectionListString(SectionType.QUALIFICATIONS, "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "MySQL, SQLite, MS SQL, HSQLDB");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Python: Django.");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        resume.addSectionListString(SectionType.QUALIFICATIONS, "Родной русский, английский \"upper intermediate\"");

        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "Alcatel",
                "Инженер по аппаратному и программному тестированию: Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2007, 2, 1),
                "Siemens AG",
                "Разработчик ПО: Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2007, 3, 1),
                LocalDate.of(2008, 6, 1),
                "Enkata",
                "Разработчик ПО: Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1),
                "Yota",
                "Ведущий специалист: Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1),
                "Luxoft (Deutsche Bank)",
                "Ведущий программист: Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1),
                "RIT Center",
                "Java архитектор: Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2014, 10, 1),
                LocalDate.of(2016, 1, 1),
                "Wrike",
                "Старший разработчик (backend): Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.");
        resume.addSectionListObject(SectionType.EXPERIENCE,
                LocalDate.of(2013, 10, 1),
                LocalDate.now(),
                "Java Online Projects",
                "Автор проекта.: Создание, организация и проведение Java онлайн проектов и стажировок.");

        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "Заочная физико-техническая школа при МФТИ",
                "Закончил с отличием");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1),
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "Инженер (программист Fortran, C)");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1),
                "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                "Аспирантура (программист С, С++)");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1),
                "Alcatel",
                "6 месяцев обучения цифровым телефонным сетям (Москва)");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1),
                "Siemens AG",
                "3 месяца обучения мобильным IN сетям (Берлин)");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1),
                "Luxoft",
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"");
        resume.addSectionListObject(SectionType.EDUCATION,
                LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1),
                "Coursera",
                "\"Functional Programming Principles in Scala\" by Martin Odersky");

        resume.show();
    }
}