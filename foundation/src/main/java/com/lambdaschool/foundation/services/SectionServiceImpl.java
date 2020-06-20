package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.models.Book;
import com.lambdaschool.foundation.models.Section;
import com.lambdaschool.foundation.repository.BookRepository;
import com.lambdaschool.foundation.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "sectionService")
public class SectionServiceImpl implements SectionService
{
   @Autowired
   private SectionRepository sectionrepos;

   @Transactional
   @Override
   public Section save(Section section)
   {
      Section newSection = new Section();

      newSection.setSectionid(section.getSectionid());
      newSection.setSectionname(section.getSectionname());

      return sectionrepos.save(newSection);
   }
}
