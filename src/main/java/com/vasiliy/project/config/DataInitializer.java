package com.vasiliy.project.config;

import com.vasiliy.project.entity.Role;
import com.vasiliy.project.entity.StorageProduct;
import com.vasiliy.project.entity.User;
import com.vasiliy.project.entity.info.*;
import com.vasiliy.project.entity.records.InflowRecord;
import com.vasiliy.project.entity.records.SoldRecord;
import com.vasiliy.project.entity.records.WrittenOffRecord;
import com.vasiliy.project.repository.*;
import com.vasiliy.project.service.CategoryService;
import com.vasiliy.project.service.DiseaseTypeService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final FormRepository formRepository;
    private final AccountingTypeRepository accountingTypeRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final StorageProductRepository storageProductRepository;
    private final InflowRecordRepository inflowRecordRepository;
    private final WrittenOffRecordRepository writtenOffRecordRepository;
    private final SoldRecordRepository soldRecordRepository;
    private final DiseaseTypeRepository diseaseTypeRepository;
    private final DiseaseTypeService diseaseTypeService;
    private final CategoryService categoryService;
    private PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.findAll().isEmpty()) {
            List<Category> categories = new ArrayList<>();

            categories.add(new Category("0010", "Вегетотропные средства"));
            categories.add(new Category("0010-0010", "Адренолитические средства"));
            categories.add(new Category("0010-0010-0010", "Альфа- и бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020", "Альфа-адреноблокаторы"));
            categories.add(new Category("0010-0010-0020-0010", "Альфа-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0030", "Бета-адреноблокаторы"));
            categories.add(new Category("0010-0010-0030-0010", "Бета-адреноблокаторы в комбинациях"));
            categories.add(new Category("0010-0010-0040", "Симпатолитики"));
            categories.add(new Category("0010-0010-0040-0010", "Симпатолитики в комбинациях"));
            categories.add(new Category("0010-0020", "Адреномиметические средства"));
            categories.add(new Category("0010-0020-0010", "Адрено- и симпатомиметики (альфа-, бета-)"));
            categories.add(new Category("0010-0020-0010-0010", "Адрено- и симпатомиметики (альфа-, бета-) в комбинациях"));
            categories.add(new Category("0010-0020-0020", "Альфа-адреномиметики"));
            categories.add(new Category("0010-0020-0020-0010", "Альфа-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0020-0030", "Бета-адреномиметики"));
            categories.add(new Category("0010-0020-0030-0010", "Бета-адреномиметики в комбинациях"));
            categories.add(new Category("0010-0030", "Холинолитические средства"));
            categories.add(new Category("0010-0030-0010", "м-, н-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010", "м-Холинолитики"));
            categories.add(new Category("0010-0030-0010-0010-0010", "м-Холинолитики в комбинациях"));
            categories.add(new Category("0010-0030-0020", "н-Холинолитики (ганглиоблокаторы)"));
            categories.add(new Category("0010-0030-0030", "н-Холинолитики (миорелаксанты)"));
            categories.add(new Category("0010-0030-0030-0010", "н-Холинолитики (миорелаксанты) в комбинациях"));
            categories.add(new Category("0010-0040", "Холиномиметические средства"));
            categories.add(new Category("0010-0040-0010", "м-, н-Холиномиметики, в т.ч. антихолинэстеразные средства"));
            categories.add(new Category("0010-0040-0020", "м-Холиномиметики"));
            categories.add(new Category("0010-0040-0020-0010", "м-Холиномиметики в комбинациях"));
            categories.add(new Category("0010-0040-0030", "н-Холиномиметики"));

            categories.add(new Category("0020", "Гематотропные средства"));
            categories.add(new Category("0020-0010", "Антиагреганты"));
            categories.add(new Category("0020-0010-0010", "Антиагреганты в комбинациях"));
            categories.add(new Category("0020-0020", "Антикоагулянты"));
            categories.add(new Category("0020-0020-0010", "Антикоагулянты в комбинациях"));
            categories.add(new Category("0020-0080", "Другие гематотропные средства"));
            categories.add(new Category("0020-0030", "Заменители плазмы и других компонентов крови"));
            categories.add(new Category("0020-0030-0010", "Заменители плазмы и других компонентов крови в комбинациях"));
            categories.add(new Category("0020-0040", "Ингибиторы фибринолиза"));
            categories.add(new Category("0020-0050", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики"));
            categories.add(new Category("0020-0050-0010", "Коагулянты (в т.ч. факторы свертывания крови), гемостатики в комбинациях"));
            categories.add(new Category("0020-0060", "Стимуляторы гемопоэза"));
            categories.add(new Category("0020-0060-0010", "Стимуляторы гемопоэза в комбинациях"));
            categories.add(new Category("0020-0070", "Фибринолитики"));

            categories.add(new Category("0030", "Гомеопатические средства"));

            categories.add(new Category("0040", "Гормоны и их антагонисты"));
            categories.add(new Category("0040-0010", "Андрогены, антиандрогены"));
            categories.add(new Category("0040-0010-0010", "Андрогены, антиандрогены в комбинациях"));
            categories.add(new Category("0040-0020", "Глюкагон и его аналоги"));
            categories.add(new Category("0040-0030", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты"));
            categories.add(new Category("0040-0030-0010", "Гормоны гипоталамуса, гипофиза, гонадотропины и их антагонисты в комбинациях"));
            categories.add(new Category("0040-0040", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты (включая антитиреоидные средства)"));
            categories.add(new Category("0040-0040-0010", "Гормоны щитовидной и паращитовидных желез, их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0040-0080", "Другие гормоны, их аналоги и антагонисты"));
            categories.add(new Category("0040-0050", "Инсулины"));
            categories.add(new Category("0040-0050-0010", "Инсулины в комбинациях"));
            categories.add(new Category("0040-0060", "Кортикостероиды"));
            categories.add(new Category("0040-0060-0010", "Глюкокортикостероиды"));
            categories.add(new Category("0040-0060-0010-0010", "Глюкокортикостероиды в комбинациях"));
            categories.add(new Category("0040-0060-0020", "Минералокортикоиды"));
            categories.add(new Category("0040-0070", "Эстрогены, гестагены; их гомологи и антагонисты"));
            categories.add(new Category("0040-0070-0010", "Эстрогены, гестагены; их гомологи и антагонисты в комбинациях"));

            categories.add(new Category("0050", "Диагностические средства"));
            categories.add(new Category("0050-0030", "Другие диагностические средства"));
            categories.add(new Category("0050-0010", "Иммунобиологические диагностические средства"));
            categories.add(new Category("0050-0020", "Контрастные средства"));
            categories.add(new Category("0050-0020-0020", "Магнитно-резонансные контрастные средства"));
            categories.add(new Category("0050-0020-0010", "Рентгеноконтрастные средства"));
            categories.add(new Category("0050-0020-0030", "Ультразвуковые контрастные средства"));

            categories.add(new Category("0060", "Иммунотропные средства"));
            categories.add(new Category("0060-0010", "Вакцины, сыворотки, фаги и анатоксины"));
            categories.add(new Category("0060-0010-0010", "Вакцины, сыворотки, фаги и анатоксины в комбинациях"));
            categories.add(new Category("0060-0150", "Иммуноглобулины"));
            categories.add(new Category("0060-0150-0150", "Иммуноглобулины в комбинациях"));
            categories.add(new Category("0060-0030", "Иммунодепрессанты"));
            categories.add(new Category("0060-0040", "Иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040", "Другие иммуномодуляторы"));
            categories.add(new Category("0060-0040-0040-0010", "Другие иммуномодуляторы в комбинациях"));
            categories.add(new Category("0060-0040-0030", "Индукторы интерферонов"));
            categories.add(new Category("0060-0040-0010", "Интерлейкины"));
            categories.add(new Category("0060-0040-0020", "Интерфероны"));
            categories.add(new Category("0060-0040-0020-0010", "Интерфероны в комбинациях"));

            categories.add(new Category("0070", "Интермедианты"));
            categories.add(new Category("0070-0005", "Агонисты I1-имидазолиновых рецепторов"));
            categories.add(new Category("0070-0010", "Аденозинергические средства"));
            categories.add(new Category("0070-0010-0010", "Аденозинергические средства в комбинациях"));
            categories.add(new Category("0070-0020", "Антагонисты рецепторов ангиотензина II (AT1-подтип)"));
            categories.add(new Category("0070-0020-0010", "Антагонисты рецепторов ангиотензина II (AT1-подтип) в комбинациях"));
            categories.add(new Category("0070-0030", "Гистаминергические средства"));
            categories.add(new Category("0070-0030-0010", "Гистаминолитики"));
            categories.add(new Category("0070-0030-0010-0030", "Стабилизаторы мембран тучных клеток"));
            categories.add(new Category("0070-0030-0020", "Гистаминомиметики"));
            categories.add(new Category("0070-0040", "Дофаминомиметики"));
            categories.add(new Category("0070-0040-0010", "Дофаминомиметики в комбинациях"));
            categories.add(new Category("0070-0070", "Другие интермедианты"));
            categories.add(new Category("0070-0026", "Ингибиторы ФДЭ-5"));
            categories.add(new Category("0070-0050", "Простагландины, тромбоксаны, лейкотриены, их аналоги и антагонисты"));
            categories.add(new Category("0070-0050-0010", "Простагландины, тромбоксаны, лейкотриены их аналоги и антагонисты в комбинациях"));
            categories.add(new Category("0070-0060", "Серотонинергические средства"));
            categories.add(new Category("0070-0060-0010", "Серотонинергические средства в комбинациях"));

            categories.add(new Category("0080", "Метаболики"));
            categories.add(new Category("0080-0010", "Анаболики"));
            categories.add(new Category("0080-0010-0010", "Анаболики в комбинациях"));
            categories.add(new Category("0080-0020", "Антигипоксанты и антиоксиданты"));
            categories.add(new Category("0080-0020-0010", "Антигипоксанты и антиоксиданты в комбинациях"));
            categories.add(new Category("0080-0030", "Белки и аминокислоты"));
            categories.add(new Category("0080-0030-0010", "Белки и аминокислоты в комбинациях"));
            categories.add(new Category("0080-0040", "Витамины и витаминоподобные средства"));
            categories.add(new Category("0080-0040-0030", "Витамины водорастворимые"));
            categories.add(new Category("0080-0040-0030-0010", "Витамины группы B"));
            categories.add(new Category("0080-0040-0010", "Витамины и витаминоподобные средства в комбинациях"));
            categories.add(new Category("0080-0050", "Гипергликемические средства"));
            categories.add(new Category("0080-0060", "Гипогликемические синтетические и другие средства"));
            categories.add(new Category("0080-0060-0010", "Гипогликемические синтетические и другие средства в комбинациях"));
            categories.add(new Category("0080-0070", "Гиполипидемические средства"));
            categories.add(new Category("0080-0070-0055", "Гиполипидемические средства в комбинациях"));
            categories.add(new Category("0080-0070-0060", "Другие гиполипидемические средства"));
            categories.add(new Category("0080-0070-0060-0010", "Другие гиполипидемические средства в комбинациях"));
            categories.add(new Category("0080-0070-0020", "Никотинаты"));
            categories.add(new Category("0080-0070-0030", "Секвестранты желчных кислот"));
            categories.add(new Category("0080-0070-0040", "Статины"));
            categories.add(new Category("0080-0070-0050", "Фибраты"));
            categories.add(new Category("0080-0080", "Детоксицирующие средства, включая антидоты"));
            categories.add(new Category("0080-0080-0010", "Детоксицирующие средства, включая антидоты, в комбинациях"));
            categories.add(new Category("0080-0160", "Другие метаболики"));
            categories.add(new Category("0080-0160-0010", "Другие метаболики в комбинациях"));
            categories.add(new Category("0080-0155", "Ингибиторы энкефалиназы"));
            categories.add(new Category("0080-0090", "Корректоры метаболизма костной и хрящевой ткани"));
            categories.add(new Category("0080-0090-0010", "Корректоры метаболизма костной и хрящевой ткани в комбинациях"));
            categories.add(new Category("0080-0100", "Макро- и микроэлементы"));
            categories.add(new Category("0080-0100-0010", "Макро- и микроэлементы в комбинациях"));
            categories.add(new Category("0080-0110", "Регидратанты"));
            categories.add(new Category("0080-0110-0010", "Регидратанты в комбинациях"));
            categories.add(new Category("0080-0120", "Регуляторы водно-электролитного баланса и КЩС"));
            categories.add(new Category("0080-0120-0010", "Регуляторы водно-электролитного баланса и КЩС в комбинациях"));
            categories.add(new Category("0080-0135", "Средства для энтерального и парентерального питания"));
            categories.add(new Category("0080-0135-0010", "Средства для энтерального и парентерального питания в комбинациях"));
            categories.add(new Category("0080-0130", "Средства, влияющие на обмен мочевой кислоты"));
            categories.add(new Category("0080-0140", "Средства, препятствующие образованию и способствующие растворению конкрементов"));
            categories.add(new Category("0080-0140-0010", "Средства, препятствующие образованию и способствующие растворению конкрементов в комбинациях"));
            categories.add(new Category("0080-0150", "Ферменты и антиферменты"));
            categories.add(new Category("0080-0150-0010", "Ферменты и антиферменты в комбинациях"));

            categories.add(new Category("0090", "Нейротропные средства"));
            categories.add(new Category("0090-0010", "Анксиолитики"));
            categories.add(new Category("0090-0020", "Антидепрессанты"));
            categories.add(new Category("0090-0020-0010", "Антидепрессанты в комбинациях"));
            categories.add(new Category("0090-0130", "Другие нейротропные средства"));
            categories.add(new Category("0090-0130-0010", "Другие нейротропные средства в комбинации"));
            categories.add(new Category("0090-0030", "Местнораздражающие средства"));
            categories.add(new Category("0090-0030-0010", "Местнораздражающие средства в комбинациях"));
            categories.add(new Category("0090-0040", "Местные анестетики"));
            categories.add(new Category("0090-0040-0010", "Местные анестетики в комбинациях"));
            categories.add(new Category("0090-0050", "Наркозные средства"));
            categories.add(new Category("0090-0060", "Нейролептики"));
            categories.add(new Category("0090-0063", "Ноотропы"));
            categories.add(new Category("0090-0063-0010", "Ноотропы в комбинациях"));
            categories.add(new Category("0090-0065", "Нормотимики"));
            categories.add(new Category("0090-0070", "Общетонизирующие средства и адаптогены"));
            categories.add(new Category("0090-0070-0010", "Общетонизирующие средства и адаптогены в комбинациях"));
            categories.add(new Category("0090-0080", "Опиоиды, их аналоги и антагонисты"));
            categories.add(new Category("0090-0080-0030", "Опиоидные наркотические анальгетики"));
            categories.add(new Category("0090-0080-0030-0050", "Опиоидные наркотические анальгетики в комбинациях"));
            categories.add(new Category("0090-0080-0010", "Опиоидные ненаркотические анальгетики"));
            categories.add(new Category("0090-0080-0010-0010", "Опиоидные ненаркотические анальгетики в комбинациях"));
            categories.add(new Category("0090-0090", "Противопаркинсонические средства"));
            categories.add(new Category("0090-0090-0010", "Противопаркинсонические средства в комбинациях"));
            categories.add(new Category("0090-0100", "Противоэпилептические средства"));
            categories.add(new Category("0090-0100-0010", "Противоэпилептические средства в комбинациях"));
            categories.add(new Category("0090-0105", "Психостимуляторы"));
            categories.add(new Category("0090-0105-0010", "Психостимуляторы в комбинациях"));
            categories.add(new Category("0090-0115", "Седативные средства"));
            categories.add(new Category("0090-0115-0010", "Седативные средства в комбинациях"));
            categories.add(new Category("0090-0117", "Снотворные средства"));
            categories.add(new Category("0090-0117-0010", "Снотворные средства в комбинациях"));
            categories.add(new Category("0090-0120", "Средства, влияющие на нервно-мышечную передачу"));

            categories.add(new Category("0100", "Ненаркотические анальгетики, включая нестероидные и другие противовоспалительные средства"));
            categories.add(new Category("0100-0090", "Анилиды"));
            categories.add(new Category("0100-0090-0010", "Анилиды в комбинациях"));
            categories.add(new Category("0100-0030", "НПВС — Бутилпиразолидины"));
            categories.add(new Category("0100-0030-0010", "НПВС — Бутилпиразолидины в комбинациях"));
            categories.add(new Category("0100-0080", "НПВС — Коксибы"));
            categories.add(new Category("0100-0050", "НПВС — Оксикамы"));
            categories.add(new Category("0100-0050-0010", "НПВС — Оксикамы в комбинациях"));
            categories.add(new Category("0100-0020", "НПВС — Пиразолоны"));
            categories.add(new Category("0100-0020-0010", "НПВС — Пиразолоны в комбинациях"));
            categories.add(new Category("0100-0060", "НПВС — Производные пропионовой кислоты"));
            categories.add(new Category("0100-0060-0010", "НПВС — Производные пропионовой кислоты в комбинациях"));
            categories.add(new Category("0100-0010", "НПВС — Производные салициловой кислоты"));
            categories.add(new Category("0100-0010-0010", "НПВС — Производные салициловой кислоты в комбинациях"));
            categories.add(new Category("0100-0040", "НПВС — Производные уксусной кислоты и родственные соединения"));
            categories.add(new Category("0100-0040-0010", "НПВС — Производные уксусной кислоты и родственные соединения в комбинациях"));
            categories.add(new Category("0100-0070", "НПВС — Фенаматы"));
            categories.add(new Category("0100-0200", "Прочие ненаркотические анальгетики, включая нестероидные и другие противовоспалительные средства"));

            categories.add(new Category("0110", "Органотропные средства"));
            categories.add(new Category("0110-0010", "Дерматотропные средства"));
            categories.add(new Category("0110-0010-0010", "Дерматотропные средства в комбинациях"));
            categories.add(new Category("0110-0070", "Другие органотропные средства"));
            categories.add(new Category("0110-0020", "Желудочно-кишечные средства"));
            categories.add(new Category("0110-0020-0010", "Адсорбенты"));
            categories.add(new Category("0110-0020-0010-0010", "Адсорбенты в комбинациях"));
            categories.add(new Category("0110-0020-0020", "Антациды"));
            categories.add(new Category("0110-0020-0020-0010", "Антациды в комбинациях"));
            categories.add(new Category("0110-0020-0030", "Ветрогонные средства"));
            categories.add(new Category("0110-0020-0030-0010", "Ветрогонные средства в комбинациях"));
            categories.add(new Category("0110-0020-0035", "Гастропротекторы"));
            categories.add(new Category("0110-0020-0040", "Гепатопротекторы"));
            categories.add(new Category("0110-0020-0040-0010", "Гепатопротекторы в комбинациях"));
            categories.add(new Category("0110-0020-0140", "Другие желудочно-кишечные средства"));
            categories.add(new Category("0110-0020-0140-0010", "Другие желудочно-кишечные средства в комбинациях"));
            categories.add(new Category("0110-0020-0050", "Желчегонные средства и препараты желчи"));
            categories.add(new Category("0110-0020-0050-0010", "Желчегонные средства и препараты желчи в комбинациях"));
            categories.add(new Category("0110-0020-0070", "Ингибиторы протонного насоса"));
            categories.add(new Category("0110-0020-0070-0010", "Ингибиторы протонного насоса в комбинациях"));
            categories.add(new Category("0110-0020-0085", "Прокинетики"));
            categories.add(new Category("0110-0020-0075", "Противодиарейные средства"));
            categories.add(new Category("0110-0020-0075-0010", "Противодиарейные средства в комбинациях"));
            categories.add(new Category("0110-0020-0080", "Противорвотные средства"));
            categories.add(new Category("0110-0020-0080-0010", "Противорвотные средства в комбинациях"));
            categories.add(new Category("0110-0020-0090", "Регуляторы аппетита"));
            categories.add(new Category("0110-0020-0090-0010", "Регуляторы аппетита в комбинациях"));
            categories.add(new Category("0110-0020-0100", "Слабительные средства"));
            categories.add(new Category("0110-0020-0100-0010", "Слабительные средства в комбинациях"));
            categories.add(new Category("0110-0020-0110", "Средства, нормализующие микрофлору кишечника"));
            categories.add(new Category("0110-0020-0110-0010", "Средства, нормализующие микрофлору кишечника, в комбинациях"));
            categories.add(new Category("0110-0020-0120", "Стимуляторы моторики ЖКТ, в том числе рвотные средства"));
            categories.add(new Category("0110-0020-0130", "Стоматологические средства"));
            categories.add(new Category("0110-0020-0130-0010", "Стоматологические средства в комбинациях"));
            categories.add(new Category("0110-0025", "Офтальмологические средства"));
            categories.add(new Category("0110-0025-0010", "Офтальмологические средства в комбинациях"));
            categories.add(new Category("0110-0030", "Респираторные средства"));
            categories.add(new Category("0110-0030-0010", "Антиконгестанты"));
            categories.add(new Category("0110-0030-0010-0010", "Антиконгестанты в комбинациях"));
            categories.add(new Category("0110-0030-0060", "Другие респираторные средства"));
            categories.add(new Category("0110-0030-0060-0010", "Другие респираторные средства в комбинациях"));
            categories.add(new Category("0110-0030-0020", "Противокашлевые средства"));
            categories.add(new Category("0110-0030-0020-0010", "Противокашлевые средства в комбинациях"));
            categories.add(new Category("0110-0030-0030", "Секретолитики и стимуляторы моторной функции дыхательных путей"));
            categories.add(new Category("0110-0030-0030-0010", "Секретолитики и стимуляторы моторной функции дыхательных путей в комбинациях"));
            categories.add(new Category("0110-0030-0040", "Стимуляторы дыхания"));
            categories.add(new Category("0110-0030-0040-0010", "Стимуляторы дыхания в комбинациях"));
            categories.add(new Category("0110-0030-0050", "Сурфактанты"));
            categories.add(new Category("0110-0040", "Сердечно-сосудистые средства"));
            categories.add(new Category("0110-0040-0010", "Ангиопротекторы и корректоры микроциркуляции"));
            categories.add(new Category("0110-0040-0010-0010", "Ангиопротекторы и корректоры микроциркуляции в комбинациях"));
            categories.add(new Category("0110-0040-0015", "Антагонисты рецепторов ангиотензина II (AT1-подтип)"));
            categories.add(new Category("0110-0040-0015-0010", "Антагонисты рецепторов ангиотензина II (AT1-подтип) в комбинациях"));
            categories.add(new Category("0110-0040-0016", "Антагонисты рецепторов брадикинина"));
            categories.add(new Category("0110-0040-0020", "Антиаритмические средства"));
            categories.add(new Category("0110-0040-0020-0010", "Антиаритмические средства в комбинациях"));
            categories.add(new Category("0110-0040-0030", "Блокаторы кальциевых каналов"));
            categories.add(new Category("0110-0040-0030-0010", "Блокаторы кальциевых каналов в комбинациях"));
            categories.add(new Category("0110-0040-0040", "Вазодилататоры"));
            categories.add(new Category("0110-0040-0040-0010", "Вазодилататоры в комбинациях"));
            categories.add(new Category("0110-0040-0050", "Гипертензивные средства"));
            categories.add(new Category("0110-0040-0100", "Другие сердечно-сосудистые средства"));
            categories.add(new Category("0110-0040-0100-0010", "Другие сердечно-сосудистые средства в комбинациях"));
            categories.add(new Category("0110-0040-0060", "Ингибиторы АПФ"));
            categories.add(new Category("0110-0040-0060-0010", "Ингибиторы АПФ в комбинациях"));
            categories.add(new Category("0110-0040-0065", "Ингибиторы ренина"));
            categories.add(new Category("0110-0040-0065-0010", "Ингибиторы ренина в комбинациях"));
            categories.add(new Category("0110-0040-0070", "Корректоры нарушений мозгового кровообращения"));
            categories.add(new Category("0110-0040-0070-0010", "Корректоры нарушений мозгового кровообращения в комбинациях"));
            categories.add(new Category("0110-0040-0080", "Нитраты и нитратоподобные средства"));
            categories.add(new Category("0110-0040-0080-0010", "Нитраты и нитратоподобные средства в комбинациях"));
            categories.add(new Category("0110-0040-0090", "Сердечные гликозиды и негликозидные кардиотонические средства"));
            categories.add(new Category("0110-0040-0090-0010", "Сердечные гликозиды и негликозидные кардиотонические средства в комбинациях"));
            categories.add(new Category("0110-0050", "Спазмолитики миотропные"));
            categories.add(new Category("0110-0050-0010", "Спазмолитики миотропные в комбинациях"));
            categories.add(new Category("0110-0060", "Средства, регулирующие функцию органов мочеполовой системы и репродукцию"));
            categories.add(new Category("0110-0060-0010", "Диуретики"));
            categories.add(new Category("0110-0060-0010-0010", "Диуретики в комбинациях"));
            categories.add(new Category("0110-0060-0070", "Другие средства, регулирующие функцию органов мочеполовой системы и репродукцию"));
            categories.add(new Category("0110-0060-0020", "Контрацептивы негормональные"));
            categories.add(new Category("0110-0060-0030", "Регуляторы потенции"));
            categories.add(new Category("0110-0060-0040", "Средства, влияющие на обмен веществ в предстательной железе, и корректоры уродинамики"));
            categories.add(new Category("0110-0060-0050", "Токолитики"));
            categories.add(new Category("0110-0060-0060", "Утеротоники"));

            categories.add(new Category("0120", "Противомикробные, противопаразитарные и противоглистные средства"));
            categories.add(new Category("0120-0010", "Антибиотики"));
            categories.add(new Category("0120-0010-0010", "Аминогликозиды"));
            categories.add(new Category("0120-0010-0010-0010", "Аминогликозиды в комбинациях"));
            categories.add(new Category("0120-0010-0020", "Амфениколы"));
            categories.add(new Category("0120-0010-0020-0010", "Амфениколы в комбинациях"));
            categories.add(new Category("0120-0010-0030", "Ансамицины"));
            categories.add(new Category("0120-0010-0040", "Гликопептиды"));
            categories.add(new Category("0120-0010-0120", "Другие антибиотики"));
            categories.add(new Category("0120-0010-0120-0010", "Другие антибиотики в комбинациях"));
            categories.add(new Category("0120-0010-0050", "Карбапенемы"));
            categories.add(new Category("0120-0010-0050-0010", "Карбапенемы в комбинациях"));
            categories.add(new Category("0120-0010-0060", "Линкозамиды"));
            categories.add(new Category("0120-0010-0060-0010", "Линкозамиды в комбинациях"));
            categories.add(new Category("0120-0010-0070", "Макролиды и азалиды"));
            categories.add(new Category("0120-0010-0070-0010", "Макролиды и азалиды в комбинациях"));
            categories.add(new Category("0120-0010-0080", "Монобактамы"));
            categories.add(new Category("0120-0010-0085", "Оксазолидиноны"));
            categories.add(new Category("0120-0010-0090", "Пенициллины"));
            categories.add(new Category("0120-0010-0090-0010", "Пенициллины в комбинациях"));
            categories.add(new Category("0120-0010-0100", "Тетрациклины"));
            categories.add(new Category("0120-0010-0100-0010", "Тетрациклины в комбинациях"));
            categories.add(new Category("0120-0010-0110", "Цефалоспорины"));
            categories.add(new Category("0120-0010-0110-0010", "Цефалоспорины в комбинациях"));
            categories.add(new Category("0120-0020", "Антисептики и дезинфицирующие средства"));
            categories.add(new Category("0120-0020-0010", "Антисептики и дезинфицирующие средства в комбинациях"));
            categories.add(new Category("0120-0090", "Другие противомикробные, противопаразитарные и противоглистные средства"));
            categories.add(new Category("0120-0030", "Противовирусные средства"));
            categories.add(new Category("0120-0030-0005", "Противовирусные (за исключением ВИЧ) средства"));
            categories.add(new Category("0120-0030-0005-0010", "Противовирусные (за исключением ВИЧ) средства в комбинациях"));
            categories.add(new Category("0120-0030-0010", "Средства для лечения ВИЧ-инфекции"));
            categories.add(new Category("0120-0030-0010-0010", "Средства для лечения ВИЧ-инфекции в комбинациях"));
            categories.add(new Category("0120-0040", "Противоглистные средства"));
            categories.add(new Category("0120-0050", "Противогрибковые средства"));
            categories.add(new Category("0120-0050-0010", "Противогрибковые средства в комбинациях"));
            categories.add(new Category("0120-0070", "Противопаразитарные средства"));
            categories.add(new Category("0120-0070-0010", "Противопаразитарные средства в комбинациях"));
            categories.add(new Category("0120-0080", "Синтетические антибактериальные средства"));
            categories.add(new Category("0120-0080-0030", "Другие синтетические антибактериальные средства"));
            categories.add(new Category("0120-0080-0030-0010", "Другие синтетические антибактериальные средства в комбинациях"));
            categories.add(new Category("0120-0080-0010", "Сульфаниламиды"));
            categories.add(new Category("0120-0080-0010-0010", "Сульфаниламиды в комбинациях"));
            categories.add(new Category("0120-0080-0020", "Хинолоны/фторхинолоны"));
            categories.add(new Category("0120-0080-0020-0010", "Хинолоны/фторхинолоны в комбинациях"));

            categories.add(new Category("0130", "Противоопухолевые средства"));
            categories.add(new Category("0130-0010", "Алкилирующие средства"));
            categories.add(new Category("0130-0020", "Антиметаболиты"));
            categories.add(new Category("0130-0070", "Другие противоопухолевые средства"));
            categories.add(new Category("0130-0030", "Противоопухолевые антибиотики"));
            categories.add(new Category("0130-0040", "Противоопухолевые гормональные средства и антагонисты гормонов"));
            categories.add(new Category("0130-0060", "Противоопухолевые средства — ингибиторы протеинкиназ"));
            categories.add(new Category("0130-0055", "Противоопухолевые средства — моноклональные антитела"));
            categories.add(new Category("0130-0055-0056", "Противоопухолевые средства — моноклональные антитела в комбинациях"));
            categories.add(new Category("0130-0050", "Противоопухолевые средства растительного происхождения"));
            categories.add(new Category("0130-0050-0051", "Противоопухолевые средства растительного происхождения в комбинациях"));

            categories.add(new Category("0140", "Регенеранты и репаранты"));
            categories.add(new Category("0140-0010", "Регенеранты и репаранты в комбинациях"));

            categories.add(new Category("0160", "Разные средства"));
            categories.add(new Category("0160-0010", "Вспомогательные вещества, реактивы и полупродукты"));
            categories.add(new Category("0160-0020", "Детское питание (включая смеси)"));
            categories.add(new Category("0160-0120", "Другие разные средства"));
            categories.add(new Category("0160-0050", "Радиопрофилактические и радиотерапевтические средства"));
            categories.add(new Category("0160-0080", "Склерозирующие средства"));
            categories.add(new Category("0160-0090", "Средства для коррекции нарушений при алкоголизме, токсико- и наркомании"));

            categoryRepository.saveAll(categories);
        }


        if (diseaseTypeRepository.findAll().isEmpty()) {
            List<DiseaseType> diseaseTypes = new ArrayList<>();

            DiseaseType diseaseType1 = new DiseaseType();
            diseaseType1.setName("Болезни нервной системы");
            diseaseType1.setCategories(new ArrayList<>());
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0010"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0020"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0030"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0020"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0030"));
            diseaseType1.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0040"));
            diseaseType1.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType1.setDiseaseCountsPerYear(List.of(2227.0, 2179.0, 2246.0, 2174.0, 2228.0, 2178.0, 2318.0, 2361.0, 2419.0, 2374.0, 2345.0, 2354.0, 2329.6, 2364.5, 2369.9, 2256.6, 2231.2, 2204.1, 2167.7, 2171.9, 1836.5, 1974.8, 2057.0, 2098.9, 2135.0));

            DiseaseType diseaseType2 = new DiseaseType();
            diseaseType2.setName("Болезни системы кровообращения");
            diseaseType2.setCategories(new ArrayList<>());
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0020"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0040"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0020"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0026"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0050"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0010"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0020"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0010-0030"));
            diseaseType2.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0020"));
            diseaseType2.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType2.setDiseaseCountsPerYear(List.of(2483.0, 2605.0, 2805.0, 2954.0, 3146.0, 3278.0, 3787.0, 3719.0, 3781.0, 3761.0, 3734.0, 3803.6, 3813.7, 4284.8, 4205.0, 4563.0, 4648.6, 4706.5, 4783.7, 5135.6, 4302.5, 4455.7, 4928.7, 5196.4, 5652.8));
            diseaseType2.setMonthMultipliers(List.of(1.15, 1.10, 1.05, 1.00, 0.95, 0.95, 1.00, 1.00, 0.98, 1.02, 1.08, 1.12));

            DiseaseType diseaseType3 = new DiseaseType();
            diseaseType3.setName("Болезни органов дыхания");
            diseaseType3.setCategories(new ArrayList<>());
            diseaseType3.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0030"));
            diseaseType3.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0020"));
            diseaseType3.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010-0030"));
            diseaseType3.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0030"));
            diseaseType3.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0050"));
            diseaseType3.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType3.setDiseaseCountsPerYear(List.of(46170.0, 43012.0, 43005.0, 44560.0, 41946.0, 41915.0, 42338.0, 42958.0, 43221.0, 48148.0, 46281.0, 48436.7, 47381.3, 48568.3, 48707.9, 49463.9, 51572.6, 51905.0, 52832.6, 52277.6, 54273.3, 59381.9, 61918.8, 59829.8, 58725.4));
            diseaseType3.setMonthMultipliers(List.of(1.30, 1.25, 1.15, 1.00, 0.85, 0.75, 0.70, 0.75, 0.90, 1.10, 1.20, 1.35));

            DiseaseType diseaseType4 = new DiseaseType();
            diseaseType4.setName("Болезни органов пищеварения");
            diseaseType4.setCategories(new ArrayList<>());
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0020"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0150"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0140"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0120"));
            diseaseType4.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType4.setDiseaseCountsPerYear(List.of(4698.0, 4841.0, 5149.0, 5063.0, 5079.0, 5034.0, 5024.0, 4904.0, 4910.0, 4902.0, 4778.0, 4766.9, 4981.9, 5055.3, 5342.3, 5163.1, 5228.7, 4985.8, 4856.3, 4693.5, 3855.0, 3920.8, 3985.7, 4095.7, 4182.0));

            DiseaseType diseaseType5 = new DiseaseType();
            diseaseType5.setName("Болезни эндокринной системы и обмена веществ");
            diseaseType5.setCategories(new ArrayList<>());
            diseaseType5.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType5.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080"));
            diseaseType5.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType5.setDiseaseCountsPerYear(List.of(1234.0, 1297.0, 1546.0, 1373.0, 1407.0, 1361.0, 1672.0, 1638.0, 1629.0, 1481.0, 1461.0, 1474.5, 1519.3, 1526.7, 1635.9, 1952.8, 2037.6, 2050.1, 1926.7, 2116.7, 1617.0, 1669.7, 1831.4, 2053.4, 2419.9));

            DiseaseType diseaseType6 = new DiseaseType();
            diseaseType6.setName("Инфекционные и паразитарные болезни");
            diseaseType6.setCategories(new ArrayList<>());
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060-0010"));
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060-0040"));
            diseaseType6.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType6.setDiseaseCountsPerYear(List.of(6448.0, 6350.0, 5939.0, 5414.0, 5505.0, 5312.0, 5327.0, 5332.0, 5187.0, 4916.0, 4690.0, 4626.1, 4591.8, 4434.1, 4504.1, 4116.3, 4086.4, 4012.1, 3970.5, 3902.5, 2999.4, 3114.6, 3324.4, 3433.0, 3587.5));
            diseaseType6.setMonthMultipliers(List.of(1.25, 1.20, 1.10, 0.95, 0.90, 1.00, 1.10, 1.05, 1.00, 1.10, 1.20, 1.30));

            DiseaseType diseaseType7 = new DiseaseType();
            diseaseType7.setName("Болезни крови и иммунные нарушения");
            diseaseType7.setCategories(new ArrayList<>());
            diseaseType7.getCategories().addAll(categoryRepository.findByCodeStartingWith("0020"));
            diseaseType7.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType7.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType7.setDiseaseCountsPerYear(List.of(551.0, 563.0, 731.0, 626.0, 648.0, 647.0, 765.0, 776.0, 758.0, 724.0, 705.0, 676.3, 674.7, 668.2, 688.2, 691.6, 688.1, 659.2, 627.7, 613.0, 480.1, 513.9, 539.6, 557.0, 581.8));

            DiseaseType diseaseType8 = new DiseaseType();
            diseaseType8.setName("Новообразования");
            diseaseType8.setCategories(new ArrayList<>());
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0130"));
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType8.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType8.setDiseaseCountsPerYear(List.of(1226.0, 1239.0, 1295.0, 1287.0, 1375.0, 1357.0, 1418.0, 1437.0, 1437.0, 1525.0, 1540.0, 1586.1, 1656.0, 1628.9, 1693.1, 1671.6, 1668.1, 1674.1, 1704.6, 1744.0, 1440.1, 1484.1, 1593.8, 1711.8, 1754.7));

            DiseaseType diseaseType9 = new DiseaseType();
            diseaseType9.setName("Болезни глаза");
            diseaseType9.setCategories(new ArrayList<>());
            diseaseType9.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0025"));
            diseaseType9.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010"));
            diseaseType9.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType9.setDiseaseCountsPerYear(List.of(4638.0, 4701.0, 4836.0, 4722.0, 4871.0, 4778.0, 5107.0, 4976.0, 4858.0, 4778.0, 4715.0, 4757.6, 5043.3, 5023.4, 5067.0, 4878.3, 4786.8, 4640.7, 4612.2, 4409.6, 3506.5, 3632.4, 3679.1, 3815.1, 3895.9));

            DiseaseType diseaseType10 = new DiseaseType();
            diseaseType10.setName("Болезни уха");
            diseaseType10.setCategories(new ArrayList<>());
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0030"));
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0010"));
            diseaseType10.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType10.setDiseaseCountsPerYear(List.of(3191.0, 3234.0, 3305.0, 3231.0, 3415.0, 3425.0, 3502.0, 3563.0, 3526.0, 3733.0, 3867.0, 3975.1, 4032.4, 4013.8, 4049.9, 3893.1, 3863.4, 3799.1, 3748.4, 3668.6, 3008.1, 3112.2, 3266.3, 3505.9, 3656.4));

            DiseaseType diseaseType11 = new DiseaseType();
            diseaseType11.setName("Болезни кожи");
            diseaseType11.setCategories(new ArrayList<>());
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0010"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType11.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType11.setDiseaseCountsPerYear(List.of(6407.0, 6561.0, 6763.0, 6763.0, 6993.0, 7073.0, 7239.0, 7161.0, 7056.0, 6991.0, 6886.0, 6794.7, 6876.3, 6739.9, 6767.4, 6436.8, 6241.0, 6017.4, 5915.3, 5977.3, 4979.0, 5194.3, 5292.0, 5543.1, 5587.6));
            diseaseType11.setMonthMultipliers(List.of(0.85, 0.90, 0.95, 1.00, 1.10, 1.20, 1.30, 1.25, 1.10, 1.00, 0.95, 0.90));

            DiseaseType diseaseType12 = new DiseaseType();
            diseaseType12.setName("Болезни костно-мышечной системы");
            diseaseType12.setCategories(new ArrayList<>());
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0090"));
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0100"));
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0120"));
            diseaseType12.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType12.setDiseaseCountsPerYear(List.of(4452.0, 4583.0, 5059.0, 4818.0, 4875.0, 4746.0, 5040.0, 5022.0, 5013.0, 4952.0, 4789.0, 4808.9, 4761.0, 4633.7, 4647.0, 4409.7, 4331.5, 4331.1, 4382.4, 4450.5, 3662.6, 3893.8, 4209.8, 4561.6, 4752.0));
            diseaseType12.setMonthMultipliers(List.of(1.20, 1.15, 1.10, 1.00, 0.95, 0.90, 0.90, 0.95, 1.00, 1.05, 1.10, 1.15));

            DiseaseType diseaseType13 = new DiseaseType();
            diseaseType13.setName("Болезни мочеполовой системы");
            diseaseType13.setCategories(new ArrayList<>());
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060"));
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0026"));
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType13.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType13.setDiseaseCountsPerYear(List.of(5470.0, 5627.0, 5880.0, 6035.0, 6523.0, 6560.0, 6967.0, 6940.0, 6916.0, 6835.0, 6842.0, 7050.2, 7101.0, 7147.1, 7164.1, 6792.9, 6689.0, 6582.8, 6581.7, 6527.7, 5268.2, 5383.2, 5529.2, 5719.6, 5755.3));
            diseaseType13.setMonthMultipliers(List.of(1.05, 1.00, 0.98, 0.95, 1.00, 1.10, 1.15, 1.10, 1.05, 1.00, 1.00, 1.05));

            DiseaseType diseaseType14 = new DiseaseType();
            diseaseType14.setName("Беременность, роды");
            diseaseType14.setCategories(new ArrayList<>());
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060-0050"));
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060-0060"));
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType14.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType14.setDiseaseCountsPerYear(List.of(2085.0, 2181.0, 2386.0, 2512.0, 2468.0, 2471.0, 2519.0, 2651.0, 2736.0, 2881.0, 2888.8, 2815.7, 2832.1, 2777.8, 2801.3, 2618.1, 2450.1, 2352.4, 2203.9, 2126.4, 1973.9, 1959.7, 1824.9, 1794.1, 1727.6));

            DiseaseType diseaseType15 = new DiseaseType();
            diseaseType15.setName("Травмы, отравления");
            diseaseType15.setCategories(new ArrayList<>());
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0080"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0020-0030"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0040"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0050"));
            diseaseType15.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType15.setDiseaseCountsPerYear(List.of(12544.0, 12716.0, 12866.0, 12903.0, 12846.0, 12808.0, 12759.0, 13072.0, 13021.0, 12855.0, 13096.0, 13261.4, 13425.5, 13285.3, 13182.8, 13234.9, 13063.0, 12946.4, 13072.2, 13270.2, 11908.2, 12192.0, 12553.4, 12768.6, 13069.7));
            diseaseType15.setMonthMultipliers(List.of(1.20, 1.10, 1.00, 0.95, 1.05, 1.20, 1.30, 1.25, 1.10, 1.00, 1.05, 1.15));

            diseaseTypes.add(diseaseType1);
            diseaseTypes.add(diseaseType2);
            diseaseTypes.add(diseaseType3);
            diseaseTypes.add(diseaseType4);
            diseaseTypes.add(diseaseType5);
            diseaseTypes.add(diseaseType6);
            diseaseTypes.add(diseaseType7);
            diseaseTypes.add(diseaseType8);
            diseaseTypes.add(diseaseType9);
            diseaseTypes.add(diseaseType10);
            diseaseTypes.add(diseaseType11);
            diseaseTypes.add(diseaseType12);
            diseaseTypes.add(diseaseType13);
            diseaseTypes.add(diseaseType14);
            diseaseTypes.add(diseaseType15);

            diseaseTypeRepository.saveAll(diseaseTypes);

            diseaseTypeService.calculateEpidemicMultipliers();
            categoryService.calculateEpidemicMultipliers();
        }


        if (formRepository.findAll().isEmpty()) {
            List<Form> forms = new ArrayList<>();

            forms.add(new Form("Таблетка"));
            forms.add(new Form("Капсула"));
            forms.add(new Form("Микрокапсула"));
            forms.add(new Form("Нанокапсула"));
            forms.add(new Form("Гранулы"));
            forms.add(new Form("Драже"));
            forms.add(new Form("Пилюля"));
            forms.add(new Form("Пастилки"));
            forms.add(new Form("Порошок"));
            forms.add(new Form("Брикет"));
            forms.add(new Form("Лекарственный карандаш"));
            forms.add(new Form("Жевательная резинка"));
            forms.add(new Form("Пеллеты"));
            forms.add(new Form("Мазь"));
            forms.add(new Form("Крем"));
            forms.add(new Form("Гель"));
            forms.add(new Form("Суппозитории"));
            forms.add(new Form("Линименты"));
            forms.add(new Form("Паста"));
            forms.add(new Form("Пессарий"));
            forms.add(new Form("Пластырь"));
            forms.add(new Form("TTC"));
            forms.add(new Form("Раствор"));
            forms.add(new Form("Суспензия"));
            forms.add(new Form("Эмульсия"));
            forms.add(new Form("Капли"));
            forms.add(new Form("Микстура"));
            forms.add(new Form("Настойка"));
            forms.add(new Form("Настой"));
            forms.add(new Form("Отвар"));
            forms.add(new Form("Сироп"));
            forms.add(new Form("Аэрозоль и спреи"));
            forms.add(new Form("Газы"));
            forms.add(new Form("Лекарственный сбор"));
            forms.add(new Form("Лекарственные формы для инъекций"));

            formRepository.saveAll(forms);
        }


        if (accountingTypeRepository.findAll().isEmpty()) {
            List<AccountingType> accountingTypes = new ArrayList<>();

            accountingTypes.add(new AccountingType("Нет"));
            accountingTypes.add(new AccountingType("Группа 1 (наркотические и психотропные в-ва)"));
            accountingTypes.add(new AccountingType("Группа 2 (сильнодействующие и ядовитые в-ва)"));
            accountingTypes.add(new AccountingType("Группа 3 (комбинированные с в-вами группы 1)"));
            accountingTypes.add(new AccountingType("Группа 4 (иные)"));

            accountingTypeRepository.saveAll(accountingTypes);
        }


        if (roleRepository.findAll().isEmpty()) {
            List<Role> roles = new ArrayList<>();

            Role roleAdministrator = new Role();
            roleAdministrator.setName("Администратор");

            Role roleUser = new Role();
            roleUser.setName("Пользователь");

            roles.add(roleAdministrator);
            roles.add(roleUser);

            roleRepository.saveAll(roles);
        }


        if (userRepository.findAll().isEmpty()) {

            List<User> users = new ArrayList<>();

            User administrator = new User();
            administrator.setName("Имя Фамилия");
            administrator.setEmail("administrator@gmail.com");
            administrator.setPassword(passwordEncoder.encode("password"));
            administrator.setRoles(Collections.singletonList(roleRepository.findByName("Администратор")));

            users.add(administrator);

            userRepository.saveAll(users);
        }


        if (supplierRepository.findAll().isEmpty()) {

            List<Supplier> suppliers = new ArrayList<>();

            Supplier supplier1 = new Supplier();
            supplier1.setName("МедФарм");
            supplier1.setAddress("Тула, ул. Арсенальная, д. 33");
            supplier1.setPhoneNumber("+76372619485");

            Supplier supplier2 = new Supplier();
            supplier2.setName("Лекарственная Линия");
            supplier2.setAddress("Орёл, ул. Ленина, д. 5");
            supplier2.setPhoneNumber("+75425670993");

            Supplier supplier3 = new Supplier();
            supplier3.setName("Фарм Дистрибьюшн");
            supplier3.setAddress("Москва, ул. Амурская, д. 17");
            supplier3.setPhoneNumber("+77774684202");

            suppliers.add(supplier1);
            suppliers.add(supplier2);
            suppliers.add(supplier3);

            supplierRepository.saveAll(suppliers);
        }


        if (productRepository.findAll().isEmpty()) {

            List<Product> products = new ArrayList<>();

            Product product1 = new Product();
            product1.setName("Велкардио");
            product1.setCategory(categoryRepository.findByName("Альфа- и бета-адреноблокаторы"));
            product1.setForm(formRepository.findByName("Таблетка"));
            product1.setExpirationDays(120L);
            product1.setIsVital(true);
            product1.setIsPrescriptive(true);
            product1.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product2 = new Product();
            product2.setName("Глицин Канон");
            product2.setCategory(categoryRepository.findByName("Седативные средства"));
            product2.setForm(formRepository.findByName("Таблетка"));
            product2.setExpirationDays(730L);
            product2.setIsVital(true);
            product2.setIsPrescriptive(false);
            product2.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product3 = new Product();
            product3.setName("Валериана Форте");
            product3.setCategory(categoryRepository.findByName("Седативные средства"));
            product3.setForm(formRepository.findByName("Таблетка"));
            product3.setExpirationDays(730L);
            product3.setIsVital(false);
            product3.setIsPrescriptive(false);
            product3.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product4 = new Product();
            product4.setName("Полисорб МП");
            product4.setCategory(categoryRepository.findByName("Адсорбенты"));
            product4.setForm(formRepository.findByName("Суспензия"));
            product4.setExpirationDays(1825L);
            product4.setIsVital(false);
            product4.setIsPrescriptive(false);
            product4.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product5 = new Product();
            product5.setName("Оксациллин");
            product5.setCategory(categoryRepository.findByName("Пенициллины"));
            product5.setForm(formRepository.findByName("Раствор"));
            product5.setExpirationDays(730L);
            product5.setIsVital(true);
            product5.setIsPrescriptive(true);
            product5.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product6 = new Product();
            product6.setName("Иммуновенин");
            product6.setCategory(categoryRepository.findByName("Иммуноглобулины"));
            product6.setForm(formRepository.findByName("Раствор"));
            product6.setExpirationDays(730L);
            product6.setIsVital(true);
            product6.setIsPrescriptive(true);
            product6.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product7 = new Product();
            product7.setName("Моноинсулин ЧР");
            product7.setCategory(categoryRepository.findByName("Инсулины"));
            product7.setForm(formRepository.findByName("Раствор"));
            product7.setExpirationDays(912L);
            product7.setIsVital(true);
            product7.setIsPrescriptive(true);
            product7.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product8 = new Product();
            product8.setName("Клофелин");
            product8.setCategory(categoryRepository.findByName("Альфа-адреномиметики"));
            product8.setForm(formRepository.findByName("Капли"));
            product8.setExpirationDays(730L);
            product8.setIsVital(false);
            product8.setIsPrescriptive(true);
            product8.setAccountingType(accountingTypeRepository.findByName("Группа 2 (сильнодействующие и ядовитые в-ва)"));

            Product product9 = new Product();
            product9.setName("Бускопан");
            product9.setCategory(categoryRepository.findByName("м-Холинолитики"));
            product9.setForm(formRepository.findByName("Таблетка"));
            product9.setExpirationDays(1095L);
            product9.setIsVital(false);
            product9.setIsPrescriptive(false);
            product9.setAccountingType(accountingTypeRepository.findByName("Нет"));

            Product product10 = new Product();
            product10.setName("Трентал");
            product10.setCategory(categoryRepository.findByName("Антиагреганты"));
            product10.setForm(formRepository.findByName("Таблетка"));
            product10.setExpirationDays(1460L);
            product10.setIsVital(false);
            product10.setIsPrescriptive(false);
            product10.setAccountingType(accountingTypeRepository.findByName("Нет"));

            products.add(product1);
            products.add(product2);
            products.add(product3);
            products.add(product4);
            products.add(product5);
            products.add(product6);
            products.add(product7);
            products.add(product8);
            products.add(product9);
            products.add(product10);

            productRepository.saveAll(products);
        }


        if (storageProductRepository.findAll().isEmpty()) {

            List<StorageProduct> storageProducts = new ArrayList<>();

            StorageProduct storageProduct1 = new StorageProduct();
            storageProduct1.setProduct(productRepository.findByName("Велкардио"));
            storageProduct1.setSupplier(supplierRepository.findByName("МедФарм"));
            storageProduct1.setQuantity(100L);
            storageProduct1.setExpiresAt(LocalDateTime.of(2026, Month.APRIL, 27, 19, 34));

            StorageProduct storageProduct2 = new StorageProduct();
            storageProduct2.setProduct(productRepository.findByName("Глицин Канон"));
            storageProduct2.setSupplier(supplierRepository.findByName("Лекарственная Линия"));
            storageProduct2.setQuantity(143L);
            storageProduct2.setExpiresAt(LocalDateTime.of(2026, Month.OCTOBER, 28, 19, 35));

            StorageProduct storageProduct3 = new StorageProduct();
            storageProduct3.setProduct(productRepository.findByName("Валериана Форте"));
            storageProduct3.setSupplier(supplierRepository.findByName("Фарм Дистрибьюшн"));
            storageProduct3.setQuantity(78L);
            storageProduct3.setExpiresAt(LocalDateTime.of(2026, Month.NOVEMBER, 9, 19, 37));

            storageProducts.add(storageProduct1);
            storageProducts.add(storageProduct2);
            storageProducts.add(storageProduct3);

            storageProductRepository.saveAll(storageProducts);
        }


        if (inflowRecordRepository.findAll().isEmpty()) {

            List<InflowRecord> inflowRecords = new ArrayList<>();

            InflowRecord inflowRecord1 = new InflowRecord();
            inflowRecord1.setStorageProduct(storageProductRepository.findById(1L).get());
            inflowRecord1.setQuantity(100L);
            inflowRecord1.setPriceBought(200.0);
            inflowRecord1.setWrittenAt(LocalDateTime.of(2026, Month.MARCH, 29, 19, 34));

            InflowRecord inflowRecord2 = new InflowRecord();
            inflowRecord2.setStorageProduct(storageProductRepository.findById(2L).get());
            inflowRecord2.setQuantity(143L);
            inflowRecord2.setPriceBought(232.0);
            inflowRecord2.setWrittenAt(LocalDateTime.of(2026, Month.MARCH, 29, 19, 36));

            InflowRecord inflowRecord3 = new InflowRecord();
            inflowRecord3.setStorageProduct(storageProductRepository.findById(3L).get());
            inflowRecord3.setQuantity(78L);
            inflowRecord3.setPriceBought(100.0);
            inflowRecord3.setWrittenAt(LocalDateTime.of(2026, Month.MARCH, 29, 19, 37));

            inflowRecords.add(inflowRecord1);
            inflowRecords.add(inflowRecord2);
            inflowRecords.add(inflowRecord3);

            inflowRecordRepository.saveAll(inflowRecords);
        }


        if (soldRecordRepository.findAll().isEmpty()) {

            List<SoldRecord> soldRecords = new ArrayList<>();

            SoldRecord soldRecord1 = new SoldRecord();
            soldRecord1.setStorageProduct(storageProductRepository.findById(2L).get());
            soldRecord1.setQuantity(24L);
            soldRecord1.setPriceSold(150.0);
            soldRecord1.setSoldAt(LocalDateTime.of(2026, Month.JANUARY, 29, 19, 43));

            SoldRecord soldRecord2 = new SoldRecord();
            soldRecord2.setStorageProduct(storageProductRepository.findById(2L).get());
            soldRecord2.setQuantity(10L);
            soldRecord2.setPriceSold(160.0);
            soldRecord2.setSoldAt(LocalDateTime.of(2026, Month.MARCH, 27, 19, 44));

            SoldRecord soldRecord3 = new SoldRecord();
            soldRecord3.setStorageProduct(storageProductRepository.findById(2L).get());
            soldRecord3.setQuantity(2L);
            soldRecord3.setPriceSold(164.0);
            soldRecord3.setSoldAt(LocalDateTime.of(2026, Month.FEBRUARY, 15, 19, 44));

            SoldRecord soldRecord4 = new SoldRecord();
            soldRecord4.setStorageProduct(storageProductRepository.findById(2L).get());
            soldRecord4.setQuantity(7L);
            soldRecord4.setPriceSold(171.0);
            soldRecord4.setSoldAt(LocalDateTime.of(2026, Month.MARCH, 17, 19, 44));

            SoldRecord soldRecord5 = new SoldRecord();
            soldRecord5.setStorageProduct(storageProductRepository.findById(2L).get());
            soldRecord5.setQuantity(5L);
            soldRecord5.setPriceSold(132.0);
            soldRecord5.setSoldAt(LocalDateTime.of(2026, Month.MARCH, 14, 19, 44));

            SoldRecord soldRecord6 = new SoldRecord();
            soldRecord6.setStorageProduct(storageProductRepository.findById(3L).get());
            soldRecord6.setQuantity(4L);
            soldRecord6.setPriceSold(250.0);
            soldRecord6.setSoldAt(LocalDateTime.of(2026, Month.FEBRUARY, 5, 19, 50));

            SoldRecord soldRecord7 = new SoldRecord();
            soldRecord7.setStorageProduct(storageProductRepository.findById(3L).get());
            soldRecord7.setQuantity(8L);
            soldRecord7.setPriceSold(260.0);
            soldRecord7.setSoldAt(LocalDateTime.of(2026, Month.JANUARY, 24, 19, 50));

            soldRecords.add(soldRecord1);
            soldRecords.add(soldRecord2);
            soldRecords.add(soldRecord3);
            soldRecords.add(soldRecord4);
            soldRecords.add(soldRecord5);
            soldRecords.add(soldRecord6);
            soldRecords.add(soldRecord7);

            soldRecordRepository.saveAll(soldRecords);
        }


        if (writtenOffRecordRepository.findAll().isEmpty()) {

            List<WrittenOffRecord> writtenOffRecords = new ArrayList<>();

            WrittenOffRecord writtenOffRecord1 = new WrittenOffRecord();
            writtenOffRecord1.setStorageProduct(storageProductRepository.findById(2L).get());
            writtenOffRecord1.setQuantity(5L);
            writtenOffRecord1.setWrittenOffAt(LocalDateTime.of(2026, Month.MARCH, 29, 19, 44));

            WrittenOffRecord writtenOffRecord2 = new WrittenOffRecord();
            writtenOffRecord2.setStorageProduct(storageProductRepository.findById(2L).get());
            writtenOffRecord2.setQuantity(37L);
            writtenOffRecord2.setWrittenOffAt(LocalDateTime.of(2026, Month.MARCH, 27, 19, 44));

            WrittenOffRecord writtenOffRecord3 = new WrittenOffRecord();
            writtenOffRecord3.setStorageProduct(storageProductRepository.findById(3L).get());
            writtenOffRecord3.setQuantity(13L);
            writtenOffRecord3.setWrittenOffAt(LocalDateTime.of(2026, Month.MARCH, 28, 19, 50));

            WrittenOffRecord writtenOffRecord4 = new WrittenOffRecord();
            writtenOffRecord4.setStorageProduct(storageProductRepository.findById(3L).get());
            writtenOffRecord4.setQuantity(5L);
            writtenOffRecord4.setWrittenOffAt(LocalDateTime.of(2026, Month.FEBRUARY, 2, 19, 50));

            writtenOffRecords.add(writtenOffRecord1);
            writtenOffRecords.add(writtenOffRecord2);
            writtenOffRecords.add(writtenOffRecord3);
            writtenOffRecords.add(writtenOffRecord4);

            writtenOffRecordRepository.saveAll(writtenOffRecords);
        }
    }
}