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
            diseaseType1.setDiseaseCountsPerYear(List.of(15.3, 15.0, 15.6, 15.1, 15.6, 15.3, 16.2, 16.5, 16.9, 16.6, 16.4, 16.5, 16.2, 16.4, 16.2, 15.4, 15.1, 14.9, 14.7, 14.7, 12.4, 13.4, 14.0, 14.3, 14.6));

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
            diseaseType2.setDiseaseCountsPerYear(List.of(17.1, 18.0, 19.5, 20.6, 22.0, 23.0, 26.5, 26.0, 26.5, 26.3, 26.1, 26.6, 26.6, 29.8, 28.7, 31.0, 31.5, 31.9, 32.4, 34.7, 29.1, 30.3, 33.6, 35.5, 38.7));
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
            diseaseType3.setDiseaseCountsPerYear(List.of(317.2, 296.8, 298.2, 310.4, 293.4, 294.4, 296.0, 300.8, 302.8, 337.2, 324.0, 338.7, 330.5, 337.7, 332.5, 336.6, 349.9, 351.4, 357.4, 353.5, 367.4, 403.4, 422.0, 409.0, 401.9));
            diseaseType3.setMonthMultipliers(List.of(1.30, 1.25, 1.15, 1.00, 0.85, 0.75, 0.70, 0.75, 0.90, 1.10, 1.20, 1.35));

            DiseaseType diseaseType4 = new DiseaseType();
            diseaseType4.setName("Болезни органов пищеварения");
            diseaseType4.setCategories(new ArrayList<>());
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0020"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0150"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0140"));
            diseaseType4.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0120"));
            diseaseType4.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType4.setDiseaseCountsPerYear(List.of(32.3, 33.4, 35.7, 35.3, 35.5, 35.4, 35.1, 34.3, 34.4, 34.3, 33.4, 33.3, 34.7, 35.2, 36.5, 35.1, 35.5, 33.8, 32.9, 31.7, 26.1, 26.6, 27.2, 28.0, 28.6));

            DiseaseType diseaseType5 = new DiseaseType();
            diseaseType5.setName("Болезни эндокринной системы и обмена веществ");
            diseaseType5.setCategories(new ArrayList<>());
            diseaseType5.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType5.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080"));
            diseaseType5.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType5.setDiseaseCountsPerYear(List.of(8.5, 8.9, 10.7, 9.6, 9.8, 9.6, 11.7, 11.5, 11.4, 10.4, 10.2, 10.3, 10.6, 10.6, 11.2, 13.3, 13.8, 13.9, 13.0, 14.3, 10.9, 11.3, 12.5, 14.0, 16.6));

            DiseaseType diseaseType6 = new DiseaseType();
            diseaseType6.setName("Инфекционные и паразитарные болезни");
            diseaseType6.setCategories(new ArrayList<>());
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060-0010"));
            diseaseType6.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060-0040"));
            diseaseType6.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType6.setDiseaseCountsPerYear(List.of(44.3, 43.8, 41.2, 37.7, 38.5, 37.3, 37.2, 37.3, 36.3, 34.4, 32.8, 32.3, 32.0, 30.8, 30.7, 28.0, 27.7, 27.2, 26.9, 26.4, 20.3, 21.2, 22.7, 23.5, 24.5));
            diseaseType6.setMonthMultipliers(List.of(1.25, 1.20, 1.10, 0.95, 0.90, 1.00, 1.10, 1.05, 1.00, 1.10, 1.20, 1.30));

            DiseaseType diseaseType7 = new DiseaseType();
            diseaseType7.setName("Болезни крови и иммунные нарушения");
            diseaseType7.setCategories(new ArrayList<>());
            diseaseType7.getCategories().addAll(categoryRepository.findByCodeStartingWith("0020"));
            diseaseType7.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType7.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType7.setDiseaseCountsPerYear(List.of(3.8, 3.9, 5.1, 4.4, 4.5, 4.5, 5.3, 5.4, 5.3, 5.1, 4.9, 4.7, 4.7, 4.6, 4.7, 4.7, 4.7, 4.5, 4.2, 4.1, 3.3, 3.5, 3.7, 3.8, 4.0));

            DiseaseType diseaseType8 = new DiseaseType();
            diseaseType8.setName("Новообразования");
            diseaseType8.setCategories(new ArrayList<>());
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0130"));
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType8.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType8.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType8.setDiseaseCountsPerYear(List.of(8.4, 8.5, 9.0, 9.0, 9.6, 9.5, 9.9, 10.1, 10.1, 10.7, 10.8, 11.1, 11.5, 11.3, 11.6, 11.4, 11.3, 11.3, 11.5, 11.8, 9.7, 10.1, 10.9, 11.7, 12.0));

            DiseaseType diseaseType9 = new DiseaseType();
            diseaseType9.setName("Болезни глаза");
            diseaseType9.setCategories(new ArrayList<>());
            diseaseType9.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0025"));
            diseaseType9.getCategories().addAll(categoryRepository.findByCodeStartingWith("0010"));
            diseaseType9.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType9.setDiseaseCountsPerYear(List.of(31.9, 32.4, 33.5, 33.0, 34.2, 33.6, 35.7, 34.8, 34.0, 33.5, 33.0, 33.3, 35.2, 34.9, 34.6, 33.2, 32.5, 31.4, 31.2, 29.8, 23.7, 24.7, 25.1, 26.1, 26.7));

            DiseaseType diseaseType10 = new DiseaseType();
            diseaseType10.setName("Болезни уха");
            diseaseType10.setCategories(new ArrayList<>());
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0030"));
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType10.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0010"));
            diseaseType10.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType10.setDiseaseCountsPerYear(List.of(21.9, 22.3, 22.9, 22.6, 24.0, 24.1, 24.5, 24.9, 24.7, 26.1, 27.1, 27.8, 28.1, 27.9, 27.6, 26.5, 26.2, 25.7, 25.4, 24.8, 20.4, 21.1, 22.3, 24.0, 25.0));

            DiseaseType diseaseType11 = new DiseaseType();
            diseaseType11.setName("Болезни кожи");
            diseaseType11.setCategories(new ArrayList<>());
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0010"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0120"));
            diseaseType11.getCategories().addAll(categoryRepository.findByCodeStartingWith("0060"));
            diseaseType11.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType11.setDiseaseCountsPerYear(List.of(44.0, 45.3, 46.9, 47.1, 48.9, 49.7, 50.6, 50.1, 49.4, 49.0, 48.2, 47.5, 48.0, 46.9, 46.2, 43.8, 42.3, 40.7, 40.0, 40.4, 33.7, 35.3, 36.1, 37.9, 38.2));
            diseaseType11.setMonthMultipliers(List.of(0.85, 0.90, 0.95, 1.00, 1.10, 1.20, 1.30, 1.25, 1.10, 1.00, 0.95, 0.90));

            DiseaseType diseaseType12 = new DiseaseType();
            diseaseType12.setName("Болезни костно-мышечной системы");
            diseaseType12.setCategories(new ArrayList<>());
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0090"));
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0100"));
            diseaseType12.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0120"));
            diseaseType12.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType12.setDiseaseCountsPerYear(List.of(30.6, 31.6, 35.1, 33.6, 34.1, 33.3, 35.2, 35.2, 35.1, 34.7, 33.5, 33.6, 33.2, 32.2, 31.7, 30.0, 29.4, 29.3, 29.6, 30.1, 24.8, 26.4, 28.7, 31.2, 32.5));
            diseaseType12.setMonthMultipliers(List.of(1.20, 1.15, 1.10, 1.00, 0.95, 0.90, 0.90, 0.95, 1.00, 1.05, 1.10, 1.15));

            DiseaseType diseaseType13 = new DiseaseType();
            diseaseType13.setName("Болезни мочеполовой системы");
            diseaseType13.setCategories(new ArrayList<>());
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060"));
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0070-0026"));
            diseaseType13.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType13.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType13.setDiseaseCountsPerYear(List.of(37.6, 38.8, 40.8, 42.0, 45.6, 46.1, 48.7, 48.6, 48.4, 47.9, 47.9, 49.3, 49.5, 49.7, 48.9, 46.2, 45.4, 44.6, 44.5, 44.1, 35.7, 36.6, 37.7, 39.1, 39.4));
            diseaseType13.setMonthMultipliers(List.of(1.05, 1.00, 0.98, 0.95, 1.00, 1.10, 1.15, 1.10, 1.05, 1.00, 1.00, 1.05));

            DiseaseType diseaseType14 = new DiseaseType();
            diseaseType14.setName("Беременность, роды");
            diseaseType14.setCategories(new ArrayList<>());
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060-0050"));
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0110-0060-0060"));
            diseaseType14.getCategories().addAll(categoryRepository.findByCodeStartingWith("0040"));
            diseaseType14.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType14.setDiseaseCountsPerYear(List.of(52.9, 55.1, 60.2, 62.8, 62.5, 63.0, 64.2, 68.2, 71.2, 76.0, 77.2, 76.4, 77.8, 77.2, 77.5, 73.0, 68.8, 66.4, 62.4, 60.5, 56.5, 56.4, 52.9, 52.3, 50.6));

            DiseaseType diseaseType15 = new DiseaseType();
            diseaseType15.setName("Травмы, отравления");
            diseaseType15.setCategories(new ArrayList<>());
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0080-0080"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0020-0030"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0040"));
            diseaseType15.getCategories().addAll(categoryRepository.findByCodeStartingWith("0090-0050"));
            diseaseType15.setYearsAccounted(List.of("2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024"));
            diseaseType15.setDiseaseCountsPerYear(List.of(86.2, 87.7, 89.2, 89.9, 89.9, 90.0, 89.2, 91.5, 91.2, 90.0, 91.7, 92.7, 93.6, 92.4, 90.0, 90.1, 88.6, 87.7, 88.4, 89.7, 80.6, 82.8, 85.6, 87.3, 89.4));
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